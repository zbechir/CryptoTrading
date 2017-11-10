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
"id",
"price",
"quantity",
"side",
"timestamp"
})
public class JsonTrade implements Serializable
{

@JsonProperty("id")
private long id;
@JsonProperty("price")
private String price;
@JsonProperty("quantity")
private String quantity;
@JsonProperty("side")
private String side;
@JsonProperty("timestamp")
private String timestamp;
@JsonIgnore
@Valid
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -693895508796823401L;

/**
* No args constructor for use in serialization
* 
*/
public JsonTrade() {
}

/**
* 
* @param timestamp
* @param id
* @param price
* @param side
* @param quantity
*/
public JsonTrade(long id, String price, String quantity, String side, String timestamp) {
super();
this.id = id;
this.price = price;
this.quantity = quantity;
this.side = side;
this.timestamp = timestamp;
}

@JsonProperty("id")
public long getId() {
return id;
}

@JsonProperty("id")
public void setId(long id) {
this.id = id;
}

public JsonTrade withId(long id) {
this.id = id;
return this;
}

@JsonProperty("price")
public String getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(String price) {
this.price = price;
}

public JsonTrade withPrice(String price) {
this.price = price;
return this;
}

@JsonProperty("quantity")
public String getQuantity() {
return quantity;
}

@JsonProperty("quantity")
public void setQuantity(String quantity) {
this.quantity = quantity;
}

public JsonTrade withQuantity(String quantity) {
this.quantity = quantity;
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

@JsonProperty("timestamp")
public String getTimestamp() {
return timestamp;
}

@JsonProperty("timestamp")
public void setTimestamp(String timestamp) {
this.timestamp = timestamp;
}

public JsonTrade withTimestamp(String timestamp) {
this.timestamp = timestamp;
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
		return new ToStringBuilder(this).append("id", id).append("price", price).append("quantity", quantity)
				.append("side", side).append("timestamp", timestamp)
				.append("additionalProperties", additionalProperties).toString();
	}

}