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
@JsonPropertyOrder({ "date", "price", "amount", "tid", "side" })
public class JsonTrade implements Serializable {

	@JsonProperty("date")
	private long date;
	@JsonProperty("price")
	private double price;
	@JsonProperty("amount")
	private double amount;
	@JsonProperty("tid")
	private long tid;
	@JsonProperty("side")
	private String side;
	@JsonIgnore
	@Valid
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 3784494593969610819L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public JsonTrade() {
	}

	/**
	 * 
	 * @param amount
	 * @param price
	 * @param side
	 * @param tid
	 * @param date
	 */
	public JsonTrade(long date, double price, double amount, long tid, String side) {
		super();
		this.date = date;
		this.price = price;
		this.amount = amount;
		this.tid = tid;
		this.side = side;
	}

	@JsonProperty("date")
	public long getDate() {
		return date;
	}

	@JsonProperty("date")
	public void setDate(long date) {
		this.date = date;
	}

	public JsonTrade withDate(long date) {
		this.date = date;
		return this;
	}

	@JsonProperty("price")
	public double getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(double price) {
		this.price = price;
	}

	public JsonTrade withPrice(double price) {
		this.price = price;
		return this;
	}

	@JsonProperty("amount")
	public double getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public JsonTrade withAmount(double amount) {
		this.amount = amount;
		return this;
	}

	@JsonProperty("tid")
	public long getTid() {
		return tid;
	}

	@JsonProperty("tid")
	public void setTid(long tid) {
		this.tid = tid;
	}

	public JsonTrade withTid(long tid) {
		this.tid = tid;
		return this;
	}

	@JsonProperty("side")
	public String getSide() {
		return side;
	}

	@JsonProperty("side")
	public void setSide(String side) {
		this.side = side;
	}

	public JsonTrade withSide(String side) {
		this.side = side;
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

	public JsonTrade withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("date", date).append("price", price).append("amount", amount)
				.append("tid", tid).append("side", side).append("additionalProperties", additionalProperties)
				.toString();
	}

}
