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
"fullName",
"crypto",
"payinEnabled",
"payinPaymentId",
"payinConfirmations",
"payoutEnabled",
"payoutIsPaymentId",
"transferEnabled"
})
public class JsonCurrency implements Serializable
{

@JsonProperty("id")
private String id;
@JsonProperty("fullName")
private String fullName;
@JsonProperty("crypto")
private boolean crypto;
@JsonProperty("payinEnabled")
private boolean payinEnabled;
@JsonProperty("payinPaymentId")
private boolean payinPaymentId;
@JsonProperty("payinConfirmations")
private long payinConfirmations;
@JsonProperty("payoutEnabled")
private boolean payoutEnabled;
@JsonProperty("payoutIsPaymentId")
private boolean payoutIsPaymentId;
@JsonProperty("transferEnabled")
private boolean transferEnabled;
@JsonIgnore
@Valid
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
private final static long serialVersionUID = 907229891359371457L;

/**
* No args constructor for use in serialization
* 
*/
public JsonCurrency() {
}

/**
* 
* @param id
* @param payinPaymentId
* @param payinEnabled
* @param payoutEnabled
* @param transferEnabled
* @param fullName
* @param crypto
* @param payinConfirmations
* @param payoutIsPaymentId
*/
public JsonCurrency(String id, String fullName, boolean crypto, boolean payinEnabled, boolean payinPaymentId, long payinConfirmations, boolean payoutEnabled, boolean payoutIsPaymentId, boolean transferEnabled) {
super();
this.id = id;
this.fullName = fullName;
this.crypto = crypto;
this.payinEnabled = payinEnabled;
this.payinPaymentId = payinPaymentId;
this.payinConfirmations = payinConfirmations;
this.payoutEnabled = payoutEnabled;
this.payoutIsPaymentId = payoutIsPaymentId;
this.transferEnabled = transferEnabled;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

public JsonCurrency withId(String id) {
this.id = id;
return this;
}

@JsonProperty("fullName")
public String getFullName() {
return fullName;
}

@JsonProperty("fullName")
public void setFullName(String fullName) {
this.fullName = fullName;
}

public JsonCurrency withFullName(String fullName) {
this.fullName = fullName;
return this;
}

@JsonProperty("crypto")
public boolean isCrypto() {
return crypto;
}

@JsonProperty("crypto")
public void setCrypto(boolean crypto) {
this.crypto = crypto;
}

public JsonCurrency withCrypto(boolean crypto) {
this.crypto = crypto;
return this;
}

@JsonProperty("payinEnabled")
public boolean isPayinEnabled() {
return payinEnabled;
}

@JsonProperty("payinEnabled")
public void setPayinEnabled(boolean payinEnabled) {
this.payinEnabled = payinEnabled;
}

public JsonCurrency withPayinEnabled(boolean payinEnabled) {
this.payinEnabled = payinEnabled;
return this;
}

@JsonProperty("payinPaymentId")
public boolean isPayinPaymentId() {
return payinPaymentId;
}

@JsonProperty("payinPaymentId")
public void setPayinPaymentId(boolean payinPaymentId) {
this.payinPaymentId = payinPaymentId;
}

public JsonCurrency withPayinPaymentId(boolean payinPaymentId) {
this.payinPaymentId = payinPaymentId;
return this;
}

@JsonProperty("payinConfirmations")
public long getPayinConfirmations() {
return payinConfirmations;
}

@JsonProperty("payinConfirmations")
public void setPayinConfirmations(long payinConfirmations) {
this.payinConfirmations = payinConfirmations;
}

public JsonCurrency withPayinConfirmations(long payinConfirmations) {
this.payinConfirmations = payinConfirmations;
return this;
}

@JsonProperty("payoutEnabled")
public boolean isPayoutEnabled() {
return payoutEnabled;
}

@JsonProperty("payoutEnabled")
public void setPayoutEnabled(boolean payoutEnabled) {
this.payoutEnabled = payoutEnabled;
}

public JsonCurrency withPayoutEnabled(boolean payoutEnabled) {
this.payoutEnabled = payoutEnabled;
return this;
}

@JsonProperty("payoutIsPaymentId")
public boolean isPayoutIsPaymentId() {
return payoutIsPaymentId;
}

@JsonProperty("payoutIsPaymentId")
public void setPayoutIsPaymentId(boolean payoutIsPaymentId) {
this.payoutIsPaymentId = payoutIsPaymentId;
}

public JsonCurrency withPayoutIsPaymentId(boolean payoutIsPaymentId) {
this.payoutIsPaymentId = payoutIsPaymentId;
return this;
}

@JsonProperty("transferEnabled")
public boolean isTransferEnabled() {
return transferEnabled;
}

@JsonProperty("transferEnabled")
public void setTransferEnabled(boolean transferEnabled) {
this.transferEnabled = transferEnabled;
}

public JsonCurrency withTransferEnabled(boolean transferEnabled) {
this.transferEnabled = transferEnabled;
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

public JsonCurrency withAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
return this;
}

@Override
public String toString() {
return new ToStringBuilder(this).append("id", id).append("fullName", fullName).append("crypto", crypto).append("payinEnabled", payinEnabled).append("payinPaymentId", payinPaymentId).append("payinConfirmations", payinConfirmations).append("payoutEnabled", payoutEnabled).append("payoutIsPaymentId", payoutIsPaymentId).append("transferEnabled", transferEnabled).append("additionalProperties", additionalProperties).toString();
}

}