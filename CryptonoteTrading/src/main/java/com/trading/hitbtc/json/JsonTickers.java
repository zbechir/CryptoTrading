package com.trading.hitbtc.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonTickers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2741107072980306987L;
	@JsonIgnore
	@Valid
	private Map<String, JsonTicker> Tickers = new HashMap<String, JsonTicker>();

	public JsonTickers(Map<String, JsonTicker> tickers) {
		super();
		Tickers = tickers;
	}

	public JsonTickers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@JsonAnyGetter
	public Map<String, JsonTicker> getTickers() {
		return this.Tickers;
	}

	@JsonAnySetter
	public void setTickers(String name, JsonTicker value) {
		this.Tickers.put(name, value);
	}

	public JsonTickers withAdditionalProperty(String name, JsonTicker value) {
		this.Tickers.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "JsonTickers [Tickers=" + Tickers.size() + "]";
	}

}
