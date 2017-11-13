package com.trading.hitbtc.ScheduledTasks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.trading.hitbtc.json.JsonBalance;
import com.trading.hitbtc.json.JsonTicker;
import com.trading.hitbtc.models.Balance;
import com.trading.hitbtc.models.Ticker;
import com.trading.hitbtc.repos.BalanceRepo;
import com.trading.hitbtc.repos.CurrencyRepo;
import com.trading.hitbtc.repos.SymbolRepo;
import com.trading.hitbtc.repos.TickerRepo;

@Component
public class MarketInstantData {
	@Autowired
	TickerRepo tickerRepo;

	@Autowired
	SymbolRepo symbolRepo;

	@Autowired
	CurrencyRepo currencyRepo;
	
	@Autowired
	BalanceRepo balanceRepo;

	private static final Logger log = LoggerFactory.getLogger(MarketInstantData.class);

	

	@Async
	@Scheduled(fixedDelay = 60000)
	public void getAllTickers() {
		log.info("Getting the tickers...");
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		ResponseEntity<JsonTicker[]> response = restTemplate.getForEntity("https://api.hitbtc.com/api/2/public/ticker",
				JsonTicker[].class);
		JsonTicker[] json = response.getBody();
		List<Ticker> tickers = new ArrayList<>();
		for (int i = 0; i < json.length; i++) {
			if (symbolRepo.findByIdEquals(json[i].getSymbol()) == null) {
				//getAllSymbols();
			}
			Ticker tic = new Ticker();
			try {
				tic.setAsk(Double.valueOf(json[i].getAsk()));
				tic.setBid(Double.valueOf(json[i].getBid()));
				tic.setHigh(Double.valueOf(json[i].getHigh()));
				tic.setLast(Double.valueOf(json[i].getLast()));
				tic.setLow(Double.valueOf(json[i].getLow()));
				tic.setOpen(Double.valueOf(json[i].getOpen()));
				tic.setVolume(Double.valueOf(json[i].getVolume()));
				tic.setVolumeQuote(Double.valueOf(json[i].getVolumeQuote()));
				tic.setTimestamp(javax.xml.bind.DatatypeConverter.parseDateTime(json[i].getTimestamp()).getTime());
				tic.setSymbol(symbolRepo.findByIdEquals(json[i].getSymbol()));
				tickers.add(tic);
			} catch (java.lang.NullPointerException e) {
				log.warn("Error on conversion for Ticker :" + tic + " ==> Error is : " + e.getMessage());
			} catch (java.lang.NumberFormatException e) {
				log.warn("Error on conversion for Ticker :" + tic + " ==> Error is : " + e.getMessage());
			}
		}
		tickerRepo.save(tickers);
		log.info("All Tickers saved Successfully...");
	}
	
	@Async
	@Scheduled(fixedDelay = 60000)
	public void getBalance() {
		log.info("Getting the Balance...");
		List<Balance> balances= new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		HttpEntity<String> request = new HttpEntity<String>(setAuthentification());
		ResponseEntity<JsonBalance[]> response = restTemplate.exchange("https://api.hitbtc.com/api/2/account/balance",HttpMethod.GET,request, JsonBalance[].class);
		JsonBalance[] json = response.getBody();
		for (int i = 0; i < json.length; i++) {
			Balance bal=new Balance();
			bal.setAvailable(Double.valueOf(json[i].getAvailable()));
			bal.setCurrency(currencyRepo.findByIdEquals(json[i].getCurrency()));
			bal.setReserved(Double.valueOf(json[i].getReserved()));
			bal.setTimestamp(new Date());
			balances.add(bal);
		}
		log.info("Saving " + balances.size() + " Balances...");
		balanceRepo.save(balances);
		log.info("Balances Saved Successfully...");
	}

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 60000;
		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout).setSocketTimeout(timeout * 10).setAuthenticationEnabled(true).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		return new HttpComponentsClientHttpRequestFactory(client);
	}
	
	private HttpHeaders setAuthentification() {
		String plainCreds = "097dc62a2e6c3af659358684fe911b87:f7bf3f6449e9f1e9df07500bd9f0b359";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		return headers;
	}

}
