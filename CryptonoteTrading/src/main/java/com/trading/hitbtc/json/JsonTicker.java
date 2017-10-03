package com.trading.hitbtc.json;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ask", "bid", "last", "low", "high", "open", "volume", "volume_quote", "timestamp" })
public class JsonTicker implements Serializable {

	@JsonProperty("ask")
	private String ask;
	@JsonProperty("bid")
	private String bid;
	@JsonProperty("last")
	private String last;
	@JsonProperty("low")
	private String low;
	@JsonProperty("high")
	private String high;
	@JsonProperty("open")
	private String open;
	@JsonProperty("volume")
	private String volume;
	@JsonProperty("volume_quote")
	private String volumeQuote;
	@JsonProperty("timestamp")
	private long timestamp;

	private final static long serialVersionUID = -4676209090253083407L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public JsonTicker() {
	}

	/**
	 * 
	 * @param timestamp
	 * @param open
	 * @param last
	 * @param volume
	 * @param high
	 * @param low
	 * @param ask
	 * @param bid
	 * @param volumeQuote
	 */
	public JsonTicker(String ask, String bid, String last, String low, String high, String open, String volume,
			String volumeQuote, long timestamp) {
		super();
		this.ask = ask;
		this.bid = bid;
		this.last = last;
		this.low = low;
		this.high = high;
		this.open = open;
		this.volume = volume;
		this.volumeQuote = volumeQuote;
		this.timestamp = timestamp;

	}

	@JsonProperty("ask")
	public String getAsk() {
		return ask;
	}

	@JsonProperty("ask")
	public void setAsk(String ask) {
		this.ask = ask;
	}

	public JsonTicker withAsk(String ask) {
		this.ask = ask;
		return this;
	}

	@JsonProperty("bid")
	public String getBid() {
		return bid;
	}

	@JsonProperty("bid")
	public void setBid(String bid) {
		this.bid = bid;
	}

	public JsonTicker withBid(String bid) {
		this.bid = bid;
		return this;
	}

	@JsonProperty("last")
	public String getLast() {
		return last;
	}

	@JsonProperty("last")
	public void setLast(String last) {
		this.last = last;
	}

	public JsonTicker withLast(String last) {
		this.last = last;
		return this;
	}

	@JsonProperty("low")
	public String getLow() {
		return low;
	}

	@JsonProperty("low")
	public void setLow(String low) {
		this.low = low;
	}

	public JsonTicker withLow(String low) {
		this.low = low;
		return this;
	}

	@JsonProperty("high")
	public String getHigh() {
		return high;
	}

	@JsonProperty("high")
	public void setHigh(String high) {
		this.high = high;
	}

	public JsonTicker withHigh(String high) {
		this.high = high;
		return this;
	}

	@JsonProperty("open")
	public String getOpen() {
		return open;
	}

	@JsonProperty("open")
	public void setOpen(String open) {
		this.open = open;
	}

	public JsonTicker withOpen(String open) {
		this.open = open;
		return this;
	}

	@JsonProperty("volume")
	public String getVolume() {
		return volume;
	}

	@JsonProperty("volume")
	public void setVolume(String volume) {
		this.volume = volume;
	}

	public JsonTicker withVolume(String volume) {
		this.volume = volume;
		return this;
	}

	@JsonProperty("volume_quote")
	public String getVolumeQuote() {
		return volumeQuote;
	}

	@JsonProperty("volume_quote")
	public void setVolumeQuote(String volumeQuote) {
		this.volumeQuote = volumeQuote;
	}

	public JsonTicker withVolumeQuote(String volumeQuote) {
		this.volumeQuote = volumeQuote;
		return this;
	}

	@JsonProperty("timestamp")
	public long getTimestamp() {
		return timestamp;
	}

	@JsonProperty("timestamp")
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public JsonTicker withTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
