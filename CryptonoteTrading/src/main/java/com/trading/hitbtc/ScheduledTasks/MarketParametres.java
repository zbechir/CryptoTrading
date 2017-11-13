package com.trading.hitbtc.ScheduledTasks;

import java.util.ArrayList;
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

import com.trading.hitbtc.json.JsonCurrency;
import com.trading.hitbtc.json.JsonSymbol;
import com.trading.hitbtc.models.Currency;
import com.trading.hitbtc.models.Symbol;
import com.trading.hitbtc.repos.CurrencyRepo;
import com.trading.hitbtc.repos.SymbolRepo;
@Component
public class MarketParametres {

	private static final Logger log = LoggerFactory.getLogger(MarketParametres.class);
	
	@Autowired
	SymbolRepo symbolRepo;

	@Autowired
	CurrencyRepo currencyRepo;
	
	
	@Scheduled(fixedDelay = 60000)
	public void getAllcurrency() {
		log.info("Getting the Currency list...");
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		ResponseEntity<JsonCurrency[]> response = restTemplate
				.getForEntity("https://api.hitbtc.com/api/2/public/currency", JsonCurrency[].class);
		JsonCurrency[] json = response.getBody();
		List<Currency> Currencies = new ArrayList<Currency>();
		for (int i = 0; i < json.length; i++) {
			Currency cur = new Currency();
			if (currencyRepo.findByIdEquals(json[i].getId()) != null) {
				cur = currencyRepo.findByIdEquals(json[i].getId());
			}
			cur.setCrypto(json[i].isCrypto());
			cur.setFullName(json[i].getFullName());
			cur.setId(json[i].getId());
			cur.setPayinConfirmations(json[i].getPayinConfirmations());
			cur.setPayinEnabled(json[i].isPayinEnabled());
			cur.setPayinPaymentId(json[i].isPayinPaymentId());
			cur.setPayoutEnabled(json[i].isPayoutEnabled());
			cur.setPayoutIsPaymentId(json[i].isPayoutIsPaymentId());
			cur.setTransferEnabled(json[i].isTransferEnabled());
			Currencies.add(cur);
		}
		currencyRepo.save(Currencies);
		log.info("All Currency saved / Updated Successfully...");
	}

	@Scheduled(fixedDelay = 60000)
	public void getAllSymbols() {
		log.info("Getting the Symbol list...");
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		ResponseEntity<JsonSymbol[]> response = restTemplate.getForEntity("https://api.hitbtc.com/api/2/public/symbol",
				JsonSymbol[].class);
		JsonSymbol[] json = response.getBody();
		List<Symbol> Symbols = new ArrayList<Symbol>();
		for (int i = 0; i < json.length; i++) {
			Symbol sym = new Symbol();
			if (symbolRepo.findByIdEquals(json[i].getId()) != null) {
				sym = symbolRepo.findByIdEquals(json[i].getId());
			}
			sym.setBaseCurrency(currencyRepo.findByIdEquals(json[i].getBaseCurrency()));
			sym.setFeeCurrency(json[i].getFeeCurrency());
			sym.setId(json[i].getId());
			sym.setProvideLiquidityRate(json[i].getProvideLiquidityRate());
			sym.setQuantityIncrement(json[i].getQuantityIncrement());
			sym.setQuoteCurrency(currencyRepo.findByIdEquals(json[i].getQuoteCurrency()));
			sym.setTakeLiquidityRate(json[i].getTakeLiquidityRate());
			sym.setTickSize(json[i].getTickSize());
			Symbols.add(sym);
		}
		symbolRepo.save(Symbols);
		log.info("All Symbols saved / Updated Successfully...");
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 60000;
		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout).setSocketTimeout(timeout * 10).setAuthenticationEnabled(true).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		return new HttpComponentsClientHttpRequestFactory(client);
	}
}
