package com.trading.hitbtc.json;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
"trades"
})
public class JsonTrades implements Serializable
{

@JsonProperty("trades")
@Valid
private List<JsonTrade> jsonTrades = null;
@JsonIgnore
@Valid
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -3607836978840771820L;

/**
* No args constructor for use in serialization
* 
*/
public JsonTrades() {
}

/**
* 
* @param jsonTrades
*/
public JsonTrades(List<JsonTrade> jsonTrades) {
super();
this.jsonTrades = jsonTrades;
}

@JsonProperty("trades")
public List<JsonTrade> getTrades() {
return jsonTrades;
}

@JsonProperty("trades")
public void setTrades(List<JsonTrade> jsonTrades) {
this.jsonTrades = jsonTrades;
}

public JsonTrades withTrades(List<JsonTrade> jsonTrades) {
this.jsonTrades = jsonTrades;
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

public JsonTrades withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("trades", jsonTrades).append("additionalProperties", additionalProperties).toString();
}

}