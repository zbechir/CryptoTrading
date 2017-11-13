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
@JsonPropertyOrder({ "takeLiquidityRate", "provideLiquidityRate" })
public class JsonTradingFee implements Serializable {

	@JsonProperty("takeLiquidityRate")
	private String takeLiquidityRate;
	@JsonProperty("provideLiquidityRate")
	private String provideLiquidityRate;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -3505221575595485932L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public JsonTradingFee() {
	}

	/**
	 * 
	 * @param provideLiquidityRate
	 * @param takeLiquidityRate
	 */
	public JsonTradingFee(String takeLiquidityRate, String provideLiquidityRate) {
		super();
		this.takeLiquidityRate = takeLiquidityRate;
		this.provideLiquidityRate = provideLiquidityRate;
	}

	@JsonProperty("takeLiquidityRate")
	public String getTakeLiquidityRate() {
		return takeLiquidityRate;
	}

	@JsonProperty("takeLiquidityRate")
	public void setTakeLiquidityRate(String takeLiquidityRate) {
		this.takeLiquidityRate = takeLiquidityRate;
	}

	public JsonTradingFee withTakeLiquidityRate(String takeLiquidityRate) {
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

	public JsonTradingFee withProvideLiquidityRate(String provideLiquidityRate) {
		this.provideLiquidityRate = provideLiquidityRate;
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

	public JsonTradingFee withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("takeLiquidityRate", takeLiquidityRate)
				.append("provideLiquidityRate", provideLiquidityRate)
				.append("additionalProperties", additionalProperties).toString();
	}

}