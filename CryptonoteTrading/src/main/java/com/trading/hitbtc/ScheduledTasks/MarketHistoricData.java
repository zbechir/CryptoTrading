package com.trading.hitbtc.ScheduledTasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.trading.hitbtc.json.JsonTrade;
import com.trading.hitbtc.models.Symbol;
import com.trading.hitbtc.models.Trade;
import com.trading.hitbtc.repos.SymbolRepo;
import com.trading.hitbtc.repos.TradeRepo;

@Component
public class MarketHistoricData {

	private static final Logger log = LoggerFactory.getLogger(MarketHistoricData.class);

	@Autowired
	SymbolRepo symbolRepo;

	@Autowired
	TradeRepo tradeRepo;

	@Scheduled(fixedDelay = 60000)
	public void getAllTrades() {
		log.info("Getting the trades...");
		List<Symbol> symbols = symbolRepo.findAll();
		String url = "";
		List<Trade> Trades = new ArrayList<>();
		for (Iterator<Symbol> it = symbols.iterator(); it.hasNext();) {
			Symbol symbol = it.next();
			log.info("Getting the trades for symbol " + symbol.getId() + "...");
			Trade lastTrade = tradeRepo.findFirstBySymbolOrderByIdDesc(symbol);
			if (lastTrade == null) {
				url = "https://api.hitbtc.com/api/2/public/trades/" + symbol.getId()
						+ "?sort=ASC&by=id&from=0&limit=1000";
			} else {
				Long Id = lastTrade.getId() + 1;
				url = "https://api.hitbtc.com/api/2/public/trades/" + symbol.getId() + "?sort=ASC&by=id&from=" + Id
						+ "&limit=1000";
			}
			log.info("Fetching the URL = " + url);
			try {
				RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
				ResponseEntity<JsonTrade[]> response = restTemplate.getForEntity(url, JsonTrade[].class);
				JsonTrade[] json = response.getBody();
				for (int i = 0; i < json.length; i++) {
					Trade tra = new Trade();
					tra.setId(json[i].getId());
					tra.setPrice(Double.valueOf(json[i].getPrice()));
					tra.setQuantity(Double.valueOf(json[i].getQuantity()));
					tra.setSide(json[i].getSide());
					tra.setSymbol(symbol);
					tra.setTimestamp(javax.xml.bind.DatatypeConverter.parseDateTime(json[i].getTimestamp()).getTime());
					Trades.add(tra);
				}
				log.info("Adding " + json.length + " Trades to the List...");
			} catch (org.springframework.web.client.HttpServerErrorException e) {
				log.error("Fetching URL  =" + url + " Error...", e);
			}

			log.info("Trade List size " + Trades.size());
		}
		log.info("Saving " + Trades.size() + " Trades...");
		tradeRepo.save(Trades);
		log.info("Trades Saved Successfully...");

	}

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 60000;
		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout).setSocketTimeout(timeout * 10).setAuthenticationEnabled(true).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		return new HttpComponentsClientHttpRequestFactory(client);
	}
}
