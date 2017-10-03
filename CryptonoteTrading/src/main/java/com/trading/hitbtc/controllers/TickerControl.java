package com.trading.hitbtc.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.trading.hitbtc.json.JsonTicker;
import com.trading.hitbtc.json.JsonTickers;
import com.trading.hitbtc.models.Symbol;
import com.trading.hitbtc.models.Ticker;
import com.trading.hitbtc.repos.SymbolRepo;
import com.trading.hitbtc.repos.TickerRepo;

@RestController
@RequestMapping("/api")
public class TickerControl {

	@Autowired
	TickerRepo tickerRepo;

	@Autowired
	SymbolRepo symbolRepo;

	private static final Logger log = LoggerFactory.getLogger(TickerControl.class);

	@GetMapping("/ticker")
	public List<Ticker> getTickers() {
		log.info("Getting all Tickers");
		return tickerRepo.findAll(new Sort(Sort.Direction.ASC, "timestamp"));
	}
	
	@GetMapping("/ticker/populate")
	public List<Ticker> populateTickers() {
		log.info("Populating all Tickers");
		List<Ticker> addedTickers=new ArrayList<>();
		RestTemplate restTemplate = new RestTemplate();
		JsonTickers tickers = restTemplate.getForObject("https://api.hitbtc.com/api/1/public/ticker", JsonTickers.class);
		Map<String, JsonTicker> allTickers=tickers.getTickers();
		for (Map.Entry<String, JsonTicker> entry : allTickers.entrySet())
		{
		    String symbolName=entry.getKey();
		    Symbol symbol=symbolRepo.findBySymbolEquals(symbolName);
		    if(symbol==null) {
		    	log.error("Symbol : "+symbolName+" Introuvalble");
		    }else {
		    	Ticker ticker=new Ticker();
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
		    	log.info("Ticker : "+ticker+" Saved Successfully");
		    	addedTickers.add(ticker);
		    }
		}
		return addedTickers;
	}

	@GetMapping("/ticker/{symbol}")
	public ResponseEntity<Ticker> getTickersBySymbol(@PathVariable(value = "symbol") Long symbolId) {
		
		return null;
	}
}
