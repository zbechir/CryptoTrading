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
@JsonPropertyOrder({ "currency", "available", "reserved" })
public class JsonTradingBalance implements Serializable {

	@JsonProperty("currency")
	private String currency;
	@JsonProperty("available")
	private String available;
	@JsonProperty("reserved")
	private String reserved;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 1952246264503308334L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public JsonTradingBalance() {
	}

	/**
	 * 
	 * @param available
	 * @param reserved
	 * @param currency
	 */
	public JsonTradingBalance(String currency, String available, String reserved) {
		super();
		this.currency = currency;
		this.available = available;
		this.reserved = reserved;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public JsonTradingBalance withCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	@JsonProperty("available")
	public String getAvailable() {
		return available;
	}

	@JsonProperty("available")
	public void setAvailable(String available) {
		this.available = available;
	}

	public JsonTradingBalance withAvailable(String available) {
		this.available = available;
		return this;
	}

	@JsonProperty("reserved")
	public String getReserved() {
		return reserved;
	}

	@JsonProperty("reserved")
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public JsonTradingBalance withReserved(String reserved) {
		this.reserved = reserved;
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

	public JsonTradingBalance withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("currency", currency).append("available", available)
				.append("reserved", reserved).append("additionalProperties", additionalProperties).toString();
	}

}