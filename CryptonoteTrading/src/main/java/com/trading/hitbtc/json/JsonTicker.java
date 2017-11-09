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
@JsonPropertyOrder({
"ask",
"bid",
"last",
"open",
"low",
"high",
"volume",
"volumeQuote",
"timestamp",
"symbol"
})
public class JsonTicker implements Serializable
{

@JsonProperty("ask")
private String ask;
@JsonProperty("bid")
private String bid;
@JsonProperty("last")
private String last;
@JsonProperty("open")
private String open;
@JsonProperty("low")
private String low;
@JsonProperty("high")
private String high;
@JsonProperty("volume")
private String volume;
@JsonProperty("volumeQuote")
private String volumeQuote;
@JsonProperty("timestamp")
private String timestamp;
@JsonProperty("symbol")
private String symbol;
@JsonIgnore
@Valid
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -2845920199842658616L;

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
* @param symbol
* @param last
* @param volume
* @param high
* @param low
* @param ask
* @param bid
* @param volumeQuote
*/
public JsonTicker(String ask, String bid, String last, String open, String low, String high, String volume, String volumeQuote, String timestamp, String symbol) {
super();
this.ask = ask;
this.bid = bid;
this.last = last;
this.open = open;
this.low = low;
this.high = high;
this.volume = volume;
this.volumeQuote = volumeQuote;
this.timestamp = timestamp;
this.symbol = symbol;
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

@JsonProperty("volumeQuote")
public String getVolumeQuote() {
return volumeQuote;
}

@JsonProperty("volumeQuote")
public void setVolumeQuote(String volumeQuote) {
this.volumeQuote = volumeQuote;
}

public JsonTicker withVolumeQuote(String volumeQuote) {
this.volumeQuote = volumeQuote;
return this;
}

@JsonProperty("timestamp")
public String getTimestamp() {
return timestamp;
}

@JsonProperty("timestamp")
public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

public JsonTicker withTimestamp(String timestamp) {
this.timestamp = timestamp;
return this;
}

@JsonProperty("symbol")
public String getSymbol() {
return symbol;
}

@JsonProperty("symbol")
public void setSymbol(String symbol) {
this.symbol = symbol;
}

public JsonTicker withSymbol(String symbol) {
this.symbol = symbol;
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

public JsonTicker withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("ask", ask).append("bid", bid).append("last", last).append("open", open).append("low", low).append("high", high).append("volume", volume).append("volumeQuote", volumeQuote).append("timestamp", timestamp).append("symbol", symbol).append("additionalProperties", additionalProperties).toString();
}

}