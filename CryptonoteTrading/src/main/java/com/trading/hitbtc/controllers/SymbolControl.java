package com.trading.hitbtc.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import com.trading.hitbtc.json.JsonSymbol;
import com.trading.hitbtc.json.JsonSymbols;
import com.trading.hitbtc.models.Symbol;
import com.trading.hitbtc.repos.SymbolRepo;

@RestController
@RequestMapping("/api")
public class SymbolControl {

	@Autowired
	SymbolRepo symbolRepo;

	private static final Logger log = LoggerFactory.getLogger(SymbolControl.class);

	@GetMapping("/symbol")
	public List<Symbol> getAllSymbols() {
		log.info("Getting all Symbols");
		return symbolRepo.findAll(new Sort(Sort.Direction.ASC, "symbol"));
	}
	
	@GetMapping("/symbol/populate")
	public List<Symbol> populateSymbols() {
		log.info("Poulating all Symbols");
		RestTemplate restTemplate = new RestTemplate();
		JsonSymbols symbols = restTemplate.getForObject("https://api.hitbtc.com/api/1/public/symbols",
				JsonSymbols.class);
		List<JsonSymbol> allImported = symbols.getSymbols();
		List<Symbol> result=new ArrayList<Symbol>();

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
				result.add(newSymbol);

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
				result.add(found);
			}
		}
		return result;
	}

	@GetMapping("/symbol/{id}")
	public ResponseEntity<Symbol> getSymbolById(@PathVariable(value = "id") Long symbolId) {
		Symbol symbol = symbolRepo.findOne(symbolId);
		if (symbol == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(symbol);
	}
}
