package com.trading.hitbtc.ScheduledTasks;

import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.trading.hitbtc.json.JsonCurrency;
import com.trading.hitbtc.json.JsonSymbol;
import com.trading.hitbtc.json.JsonTicker;
import com.trading.hitbtc.json.JsonTrade;
import com.trading.hitbtc.models.Currency;
import com.trading.hitbtc.models.Symbol;
import com.trading.hitbtc.models.Ticker;
import com.trading.hitbtc.models.Trade;
import com.trading.hitbtc.repos.CurrencyRepo;
import com.trading.hitbtc.repos.SymbolRepo;
import com.trading.hitbtc.repos.TickerRepo;
import com.trading.hitbtc.repos.TradeRepo;

@Component
public class MarketData {
	@Autowired
	TickerRepo tickerRepo;

	@Autowired
	SymbolRepo symbolRepo;

	@Autowired
	TradeRepo tradeRepo;

	@Autowired
	CurrencyRepo currencyrepo;

	private static final Logger log = LoggerFactory.getLogger(MarketData.class);

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
			if (currencyrepo.findByIdEquals(json[i].getId()) != null) {
				cur = currencyrepo.findByIdEquals(json[i].getId());
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
		currencyrepo.save(Currencies);
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
			sym.setBaseCurrency(currencyrepo.findByIdEquals(json[i].getBaseCurrency()));
			sym.setFeeCurrency(json[i].getFeeCurrency());
			sym.setId(json[i].getId());
			sym.setProvideLiquidityRate(json[i].getProvideLiquidityRate());
			sym.setQuantityIncrement(json[i].getQuantityIncrement());
			sym.setQuoteCurrency(currencyrepo.findByIdEquals(json[i].getQuoteCurrency()));
			sym.setTakeLiquidityRate(json[i].getTakeLiquidityRate());
			sym.setTickSize(json[i].getTickSize());
			Symbols.add(sym);
		}
		symbolRepo.save(Symbols);
		log.info("All Symbols saved / Updated Successfully...");
	}

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
				getAllSymbols();
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
				url = "https://api.hitbtc.com/api/2/public/trades/" + symbol.getId() + "?sort=ASC&by=id&from="
						+ lastTrade.getId() + 1 + "&limit=1000";
			}
			log.info("Using the URL = "+url);
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
			log.info("Adding "+json.length+" Trades to the list...");
		}
		log.info("Saving " + Trades.size() + " Trades...");
		tradeRepo.save(Trades);
		log.info("Trades Saved Successfully...");

	}

	// @Async
	// @Scheduled(cron = "0 */3 * * * MON-FRI")
	// public void getAllTickers() {
	// log.info("Getting the tickers...");
	// List<Ticker> Tickers = new ArrayList<Ticker>();
	// RestTemplate restTemplate = new RestTemplate();
	// JsonTickers jsonTickers =
	// restTemplate.getForObject("https://api.hitbtc.com/api/1/public/ticker",
	// JsonTickers.class);
	// Map<String, JsonTicker> allTickers = jsonTickers.getTickers();
	//
	// for (Map.Entry<String, JsonTicker> entry : allTickers.entrySet()) {
	// try {
	// String symbolName = entry.getKey();
	// Symbol symbol = symbolRepo.findBySymbolEquals(symbolName);
	// if (symbol == null) {
	// log.error("Symbol : " + symbolName + " Introuvalble");
	// } else {
	// Ticker ticker = new Ticker();
	// ticker.setAsk(Double.valueOf(entry.getValue().getAsk()));
	// ticker.setBid(Double.valueOf(entry.getValue().getBid()));
	// ticker.setHigh(Double.valueOf(entry.getValue().getHigh()));
	// ticker.setLast(Double.valueOf(entry.getValue().getLast()));
	// ticker.setLow(Double.valueOf(entry.getValue().getLow()));
	// ticker.setOpen(Double.valueOf(entry.getValue().getOpen()));
	// ticker.setVolume(Double.valueOf(entry.getValue().getVolume()));
	// ticker.setVolumeQuote(Double.valueOf(entry.getValue().getVolumeQuote()));
	// ticker.setSymbol(symbol);
	// ticker.setTimestamp(new Date(entry.getValue().getTimestamp()));
	// Tickers.add(ticker);
	// log.info("Ticker : " + ticker + " Added successfully...");
	// }
	// } catch (java.lang.NullPointerException e) {
	// log.error("Error on conversion for Ticker :" + entry.getValue()+" For Symbol
	// : "+entry.getKey()+" ==> Error is : "+e.getMessage());
	// }
	// }
	//
	// tickerRepo.save(Tickers);
	// log.info("Tickers saved succefully...");
	// }
	//
	// @Async
	// @Scheduled(cron = "0 0 10 * * MON-FRI")
	// public void getAllSymbols() {
	// log.info("Getting All the Symbols");
	// RestTemplate restTemplate = new RestTemplate();
	// JsonSymbols symbols =
	// restTemplate.getForObject("https://api.hitbtc.com/api/1/public/symbols",
	// JsonSymbols.class);
	// List<JsonSymbol> allImported = symbols.getSymbols();
	//
	// for (Iterator<JsonSymbol> it = allImported.iterator(); it.hasNext();) {
	// JsonSymbol sym = it.next();
	// Symbol found = symbolRepo.findBySymbolEquals(sym.getSymbol());
	// if (found == null) {
	// Symbol newSymbol = new Symbol();
	// newSymbol.setCommodity(sym.getCommodity());
	// newSymbol.setCurrency(sym.getCurrency());
	// newSymbol.setLot(Double.valueOf(sym.getLot()));
	// newSymbol.setProvideLiquidityRate(Double.valueOf(sym.getProvideLiquidityRate()));
	// newSymbol.setStep(Double.valueOf(sym.getStep()));
	// newSymbol.setSymbol(sym.getSymbol());
	// newSymbol.setTakeLiquidityRate(Double.valueOf(sym.getTakeLiquidityRate()));
	// symbolRepo.save(newSymbol);
	// log.info("Symbol Added Successfully ==> " + sym.toString());
	//
	// } else {
	// found.setCommodity(sym.getCommodity());
	// found.setCurrency(sym.getCurrency());
	// found.setLot(Double.valueOf(sym.getLot()));
	// found.setProvideLiquidityRate(Double.valueOf(sym.getProvideLiquidityRate()));
	// found.setStep(Double.valueOf(sym.getStep()));
	// found.setSymbol(sym.getSymbol());
	// found.setTakeLiquidityRate(Double.valueOf(sym.getTakeLiquidityRate()));
	// symbolRepo.save(found);
	// log.info("Symbol Updated Successfully ==> " + sym.toString());
	// }
	// }
	// }
	//
	// @Scheduled(fixedDelay = 60000)
	// public void getAllTrades() {
	// String url = "";
	// List<Trade> Trades = new ArrayList<Trade>();
	// List<Symbol> symbols = symbolRepo.findAll();
	// for (Iterator<Symbol> it = symbols.iterator(); it.hasNext();) {
	//
	// Symbol symbol = it.next();
	// Trade lastTrade = tradeRepo.findFirstBySymbolOrderByTidDesc(symbol);
	// if (lastTrade == null) {
	// url = "https://api.hitbtc.com/api/1/public/" + symbol.getSymbol()
	// +
	// "/trades?by=trade_id&format_item=object&format_price=number&format_amount=number&format_amount_unit=lots&format_tid=number&side=true";
	// } else {
	// url = "https://api.hitbtc.com/api/1/public/" + symbol.getSymbol() +
	// "/trades?by=trade_id&from="
	// + lastTrade.getTid()
	// +
	// "&format_item=object&format_price=number&format_amount=number&format_amount_unit=lots&format_tid=number&side=true";
	// }
	// log.info("Getting Trades from the URL : " + url);
	// RestTemplate restTemplate = new RestTemplate();
	// JsonTrades jsonTrades = restTemplate.getForObject(url, JsonTrades.class);
	// log.info("Le nombre de Trade récupérés ==> " +
	// jsonTrades.getTrades().size());
	// for (Iterator<JsonTrade> it1 = jsonTrades.getTrades().iterator();
	// it1.hasNext();) {
	// JsonTrade jTrade = it1.next();
	// Trade trade = tradeRepo.findByTidEquals(jTrade.getTid());
	// if (trade == null) {
	// trade = new Trade();
	// }
	// trade.setAmount(jTrade.getAmount());
	// trade.setDate(new Date(jTrade.getDate()));
	// trade.setPrice(jTrade.getPrice());
	// trade.setSide(jTrade.getSide());
	// trade.setSymbol(symbol);
	// trade.setTid(jTrade.getTid());
	// Trades.add(trade);
	//
	// }
	// //log.info("Saving " + Trades.size() + " Trades...");
	// //tradeRepo.save(Trades);
	//
	// }
	// log.info("Saving " + Trades.size() + " Trades...");
	// tradeRepo.save(Trades);
	//
	// }

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 60000;
		RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout).setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout).setSocketTimeout(timeout * 10).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		return new HttpComponentsClientHttpRequestFactory(client);
	}

}
