package com.trading.hitbtc.json;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "symbols" })
public class JsonSymbols implements Serializable {

	@JsonProperty("symbols")
	private List<JsonSymbol> symbols = null;
	private final static long serialVersionUID = 1811587259900877701L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public JsonSymbols() {
	}

	/**
	 * 
	 * @param symbols
	 */
	public JsonSymbols(List<JsonSymbol> symbols) {
		super();
		this.symbols = symbols;
	}

	@JsonProperty("symbols")
	public List<JsonSymbol> getSymbols() {
		return symbols;
	}

	@JsonProperty("symbols")
	public void setSymbols(List<JsonSymbol> symbols) {
		this.symbols = symbols;
	}

	public JsonSymbols withSymbols(List<JsonSymbol> symbols) {
		this.symbols = symbols;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
