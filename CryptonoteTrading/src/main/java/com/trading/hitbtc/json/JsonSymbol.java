package com.trading.hitbtc.json;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "symbol", "step", "lot", "currency", "commodity", "takeLiquidityRate", "provideLiquidityRate" })
public class JsonSymbol implements Serializable {

	@JsonProperty("symbol")
	private String symbol;
	@JsonProperty("step")
	private String step;
	@JsonProperty("lot")
	private String lot;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("commodity")
	private String commodity;
	@JsonProperty("takeLiquidityRate")
	private String takeLiquidityRate;
	@JsonProperty("provideLiquidityRate")
	private String provideLiquidityRate;
	private final static long serialVersionUID = -4556221828501488485L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public JsonSymbol() {
	}

	/**
	 * 
	 * @param provideLiquidityRate
	 * @param commodity
	 * @param symbol
	 * @param takeLiquidityRate
	 * @param lot
	 * @param step
	 * @param currency
	 */
	public JsonSymbol(String symbol, String step, String lot, String currency, String commodity, String takeLiquidityRate,
			String provideLiquidityRate) {
		super();
		this.symbol = symbol;
		this.step = step;
		this.lot = lot;
		this.currency = currency;
		this.commodity = commodity;
		this.takeLiquidityRate = takeLiquidityRate;
		this.provideLiquidityRate = provideLiquidityRate;
	}

	@JsonProperty("symbol")
	public String getSymbol() {
		return symbol;
	}

	@JsonProperty("symbol")
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public JsonSymbol withSymbol(String symbol) {
		this.symbol = symbol;
		return this;
	}

	@JsonProperty("step")
	public String getStep() {
		return step;
	}

	@JsonProperty("step")
	public void setStep(String step) {
		this.step = step;
	}

	public JsonSymbol withStep(String step) {
		this.step = step;
		return this;
	}

	@JsonProperty("lot")
	public String getLot() {
		return lot;
	}

	@JsonProperty("lot")
	public void setLot(String lot) {
		this.lot = lot;
	}

	public JsonSymbol withLot(String lot) {
		this.lot = lot;
		return this;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public JsonSymbol withCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	@JsonProperty("commodity")
	public String getCommodity() {
		return commodity;
	}

	@JsonProperty("commodity")
	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public JsonSymbol withCommodity(String commodity) {
		this.commodity = commodity;
		return this;
	}

	@JsonProperty("takeLiquidityRate")
	public String getTakeLiquidityRate() {
		return takeLiquidityRate;
	}

	@JsonProperty("takeLiquidityRate")
	public void setTakeLiquidityRate(String takeLiquidityRate) {
		this.takeLiquidityRate = takeLiquidityRate;
	}

	public JsonSymbol withTakeLiquidityRate(String takeLiquidityRate) {
		this.takeLiquidityRate = takeLiquidityRate;
		return this;
	}

	@JsonProperty("provideLiquidityRate")
	public String getProvideLiquidityRate() {
		return provideLiquidityRate;
	}

	@JsonProperty("provideLiquidityRate")
	public void setProvideLiquidityRate(String provideLiquidityRate) {
		this.provideLiquidityRate = provideLiquidityRate;
	}

	public JsonSymbol withProvideLiquidityRate(String provideLiquidityRate) {
		this.provideLiquidityRate = provideLiquidityRate;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
