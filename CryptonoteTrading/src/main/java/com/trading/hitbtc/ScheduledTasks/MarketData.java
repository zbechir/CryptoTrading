package com.trading.hitbtc.ScheduledTasks;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.trading.hitbtc.json.JsonSymbol;
import com.trading.hitbtc.json.JsonSymbols;
import com.trading.hitbtc.json.JsonTicker;
import com.trading.hitbtc.json.JsonTickers;
import com.trading.hitbtc.json.JsonTrade;
import com.trading.hitbtc.json.JsonTrades;
import com.trading.hitbtc.models.Symbol;
import com.trading.hitbtc.models.Ticker;
import com.trading.hitbtc.models.Trade;
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

	private static final Logger log = LoggerFactory.getLogger(MarketData.class);

	@Scheduled(cron = "0 */3 * * * MON-FRI")
	public void getAllTickers() {
		log.info("Getting the tickers...");
		RestTemplate restTemplate = new RestTemplate();
		JsonTickers tickers = restTemplate.getForObject("https://api.hitbtc.com/api/1/public/ticker",
				JsonTickers.class);
		Map<String, JsonTicker> allTickers = tickers.getTickers();
		for (Map.Entry<String, JsonTicker> entry : allTickers.entrySet()) {
			String symbolName = entry.getKey();
			Symbol symbol = symbolRepo.findBySymbolEquals(symbolName);
			if (symbol == null) {
				log.error("Symbol : " + symbolName + " Introuvalble");
			} else {
				Ticker ticker = new Ticker();
				ticker.setAsk(Double.valueOf(entry.getValue().getAsk()));
				ticker.setBid(Double.valueOf(entry.getValue().getBid()));
				ticker.setHigh(Double.valueOf(entry.getValue().getHigh()));
				ticker.setLast(Double.valueOf(entry.getValue().getLast()));
				ticker.setLow(Double.valueOf(entry.getValue().getLow()));
				ticker.setOpen(Double.valueOf(entry.getValue().getOpen()));
				ticker.setVolume(Double.valueOf(entry.getValue().getVolume()));
				ticker.setVolumeQuote(Double.valueOf(entry.getValue().getVolumeQuote()));
				ticker.setSymbol(symbol);
				ticker.setTimestamp(new Date(entry.getValue().getTimestamp()));
				tickerRepo.save(ticker);
				log.info("Ticker : " + ticker + " Saved Successfully");
			}
		}
	}

	@Scheduled(cron = "0 0 10 * * MON-FRI")
	public void getAllSymbols() {
		log.info("Getting All the Symbols");
		RestTemplate restTemplate = new RestTemplate();
		JsonSymbols symbols = restTemplate.getForObject("https://api.hitbtc.com/api/1/public/symbols",
				JsonSymbols.class);
		List<JsonSymbol> allImported = symbols.getSymbols();

		for (Iterator<JsonSymbol> it = allImported.iterator(); it.hasNext();) {
			JsonSymbol sym = it.next();
			Symbol found = symbolRepo.findBySymbolEquals(sym.getSymbol());
			if (found == null) {
				Symbol newSymbol = new Symbol();
				newSymbol.setCommodity(sym.getCommodity());
				newSymbol.setCurrency(sym.getCurrency());
				newSymbol.setLot(Double.valueOf(sym.getLot()));
				newSymbol.setProvideLiquidityRate(Double.valueOf(sym.getProvideLiquidityRate()));
				newSymbol.setStep(Double.valueOf(sym.getStep()));
				newSymbol.setSymbol(sym.getSymbol());
				newSymbol.setTakeLiquidityRate(Double.valueOf(sym.getTakeLiquidityRate()));
				symbolRepo.save(newSymbol);
				log.info("Symbol Added Successfully ==> " + sym.toString());

			} else {
				found.setCommodity(sym.getCommodity());
				found.setCurrency(sym.getCurrency());
				found.setLot(Double.valueOf(sym.getLot()));
				found.setProvideLiquidityRate(Double.valueOf(sym.getProvideLiquidityRate()));
				found.setStep(Double.valueOf(sym.getStep()));
				found.setSymbol(sym.getSymbol());
				found.setTakeLiquidityRate(Double.valueOf(sym.getTakeLiquidityRate()));
				symbolRepo.save(found);
				log.info("Symbol Updated Successfully ==> " + sym.toString());
			}
		}
	}

	@Scheduled(cron = "0 */2 * * * MON-FRI")
	public void getAllTrades() {
		List<Symbol> symbols = symbolRepo.findAll();
		for (Iterator<Symbol> it = symbols.iterator(); it.hasNext();) {
			Symbol symbol = it.next();
			RestTemplate restTemplate = new RestTemplate();
			JsonTrades Trades = restTemplate.getForObject("https://api.hitbtc.com/api/1/public/" + symbol.getSymbol()
					+ "/trades?by=ts&format_item=object&format_price=number&format_amount=number&format_amount_unit=lots&format_tid=number&side=true",
					JsonTrades.class);
			for(Iterator<JsonTrade> it1 = Trades.getTrades().iterator(); it.hasNext();) {
				JsonTrade trade=it1.next();
				
			}
		}
	}
}
