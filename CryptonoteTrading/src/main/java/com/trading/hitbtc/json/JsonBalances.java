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
"balance"
})
public class JsonBalances implements Serializable
{

@JsonProperty("balance")
@Valid
private List<JsonBalance> balance = null;
@JsonIgnore
@Valid
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = -5227073643592632459L;

/**
* No args constructor for use in serialization
* 
*/
public JsonBalances() {
}

/**
* 
* @param balance
*/
public JsonBalances(List<JsonBalance> balance) {
super();
this.balance = balance;
}

@JsonProperty("balance")
public List<JsonBalance> getBalance() {
return balance;
}

@JsonProperty("balance")
public void setBalance(List<JsonBalance> balance) {
this.balance = balance;
}

public JsonBalances withBalance(List<JsonBalance> balance) {
this.balance = balance;
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

public JsonBalances withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("balance", balance).append("additionalProperties", additionalProperties).toString();
}

}