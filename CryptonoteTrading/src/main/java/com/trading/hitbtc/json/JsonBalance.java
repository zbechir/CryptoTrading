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
@JsonPropertyOrder({ "currency_code", "cash", "reserved" })
public class JsonBalance implements Serializable {

	@JsonProperty("currency_code")
	private String currencyCode;
	@JsonProperty("cash")
	private String cash;
	@JsonProperty("reserved")
	private String reserved;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 256470912612013459L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public JsonBalance() {
	}

	/**
	 * 
	 * @param currencyCode
	 * @param cash
	 * @param reserved
	 */
	public JsonBalance(String currencyCode, String cash, String reserved) {
		super();
		this.currencyCode = currencyCode;
		this.cash = cash;
		this.reserved = reserved;
	}

	@JsonProperty("currency_code")
	public String getCurrencyCode() {
		return currencyCode;
	}

	@JsonProperty("currency_code")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public JsonBalance withCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
		return this;
	}

	@JsonProperty("cash")
	public String getCash() {
		return cash;
	}

	@JsonProperty("cash")
	public void setCash(String cash) {
		this.cash = cash;
	}

	public JsonBalance withCash(String cash) {
		this.cash = cash;
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

	public JsonBalance withReserved(String reserved) {
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

	public JsonBalance withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("currencyCode", currencyCode).append("cash", cash)
				.append("reserved", reserved).append("additionalProperties", additionalProperties).toString();
	}

}