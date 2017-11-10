package com.trading.hitbtc.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "baseCurrency", "quoteCurrency", "quantityIncrement", "tickSize", "takeLiquidityRate",
		"provideLiquidityRate", "feeCurrency" })
public class JsonSymbol implements Serializable {

	@JsonProperty("id")
	private String id;
	@JsonProperty("baseCurrency")
	private String baseCurrency;
	@JsonProperty("quoteCurrency")
	private String quoteCurrency;
	@JsonProperty("quantityIncrement")
	private String quantityIncrement;
	@JsonProperty("tickSize")
	private String tickSize;
	@JsonProperty("takeLiquidityRate")
	private String takeLiquidityRate;
	@JsonProperty("provideLiquidityRate")
	private String provideLiquidityRate;
	@JsonProperty("feeCurrency")
	private String feeCurrency;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -1302520463938879697L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public JsonSymbol() {
	}

	/**
	 * 
	 * @param quantityIncrement
	 * @param id
	 * @param provideLiquidityRate
	 * @param feeCurrency
	 * @param takeLiquidityRate
	 * @param baseCurrency
	 * @param tickSize
	 * @param quoteCurrency
	 */
	public JsonSymbol(String id, String baseCurrency, String quoteCurrency, String quantityIncrement, String tickSize,
			String takeLiquidityRate, String provideLiquidityRate, String feeCurrency) {
		super();
		this.id = id;
		this.baseCurrency = baseCurrency;
		this.quoteCurrency = quoteCurrency;
		this.quantityIncrement = quantityIncrement;
		this.tickSize = tickSize;
		this.takeLiquidityRate = takeLiquidityRate;
		this.provideLiquidityRate = provideLiquidityRate;
		this.feeCurrency = feeCurrency;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	public JsonSymbol withId(String id) {
		this.id = id;
		return this;
	}

	@JsonProperty("baseCurrency")
	public String getBaseCurrency() {
		return baseCurrency;
	}

	@JsonProperty("baseCurrency")
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public JsonSymbol withBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
		return this;
	}

	@JsonProperty("quoteCurrency")
	public String getQuoteCurrency() {
		return quoteCurrency;
	}

	@JsonProperty("quoteCurrency")
	public void setQuoteCurrency(String quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
	}

	public JsonSymbol withQuoteCurrency(String quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
		return this;
	}

	@JsonProperty("quantityIncrement")
	public String getQuantityIncrement() {
		return quantityIncrement;
	}

	@JsonProperty("quantityIncrement")
	public void setQuantityIncrement(String quantityIncrement) {
		this.quantityIncrement = quantityIncrement;
	}

	public JsonSymbol withQuantityIncrement(String quantityIncrement) {
		this.quantityIncrement = quantityIncrement;
		return this;
	}

	@JsonProperty("tickSize")
	public String getTickSize() {
		return tickSize;
	}

	@JsonProperty("tickSize")
	public void setTickSize(String tickSize) {
		this.tickSize = tickSize;
	}

	public JsonSymbol withTickSize(String tickSize) {
		this.tickSize = tickSize;
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

	@JsonProperty("feeCurrency")
	public String getFeeCurrency() {
		return feeCurrency;
	}

	@JsonProperty("feeCurrency")
	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	}

	public JsonSymbol withFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public JsonSymbol withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("baseCurrency", baseCurrency)
				.append("quoteCurrency", quoteCurrency).append("quantityIncrement", quantityIncrement)
				.append("tickSize", tickSize).append("takeLiquidityRate", takeLiquidityRate)
				.append("provideLiquidityRate", provideLiquidityRate).append("feeCurrency", feeCurrency)
				.append("additionalProperties", additionalProperties).toString();
	}

}