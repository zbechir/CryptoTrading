package com.trading.hitbtc.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.trading.hitbtc.authentification.Authentification;
import com.trading.hitbtc.json.JsonBalances;
import com.trading.hitbtc.models.Symbol;
import com.trading.hitbtc.repos.BalanceRepo;

@RestController
@RequestMapping("/api")
public class BalanceControl {

	@Autowired
	BalanceRepo balanceRepo;

	private static final Logger log = LoggerFactory.getLogger(BalanceControl.class);

	@GetMapping("/balance")
	public ResponseEntity<JsonBalances> getbalance() {
		log.info("Getting Balance....");
		RestTemplate restTemplate = new RestTemplate();
		Authentification auth = new Authentification();
		String uri = "/api/1/trading/balance/?";
		uri = auth.getUri(uri);
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Signature", auth.hmacDigest(uri));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<JsonBalances> response = restTemplate.exchange("https://api.hitbtc.com"+uri, HttpMethod.GET, entity, JsonBalances.class);
		return response;
	}
}
