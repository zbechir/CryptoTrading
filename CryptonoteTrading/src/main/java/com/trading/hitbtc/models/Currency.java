package com.trading.hitbtc.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "Currency_HITBTC", indexes = { @Index(name = "uurrency_index", columnList = "id") })
public class Currency implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long CurrencyId;
	private String id;
	private String fullName;
	private boolean crypto;
	private boolean payinEnabled;
	private boolean payinPaymentId;
	private long payinConfirmations;
	private boolean payoutEnabled;
	private boolean payoutIsPaymentId;
	private boolean transferEnabled;

	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Currency(long currencyId, String id, String fullName, boolean crypto, boolean payinEnabled,
			boolean payinPaymentId, long payinConfirmations, boolean payoutEnabled, boolean payoutIsPaymentId,
			boolean transferEnabled) {
		super();
		CurrencyId = currencyId;
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

	public long getCurrencyId() {
		return CurrencyId;
	}

	public void setCurrencyId(long currencyId) {
		CurrencyId = currencyId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isCrypto() {
		return crypto;
	}

	public void setCrypto(boolean crypto) {
		this.crypto = crypto;
	}

	public boolean isPayinEnabled() {
		return payinEnabled;
	}

	public void setPayinEnabled(boolean payinEnabled) {
		this.payinEnabled = payinEnabled;
	}

	public boolean isPayinPaymentId() {
		return payinPaymentId;
	}

	public void setPayinPaymentId(boolean payinPaymentId) {
		this.payinPaymentId = payinPaymentId;
	}

	public long getPayinConfirmations() {
		return payinConfirmations;
	}

	public void setPayinConfirmations(long payinConfirmations) {
		this.payinConfirmations = payinConfirmations;
	}

	public boolean isPayoutEnabled() {
		return payoutEnabled;
	}

	public void setPayoutEnabled(boolean payoutEnabled) {
		this.payoutEnabled = payoutEnabled;
	}

	public boolean isPayoutIsPaymentId() {
		return payoutIsPaymentId;
	}

	public void setPayoutIsPaymentId(boolean payoutIsPaymentId) {
		this.payoutIsPaymentId = payoutIsPaymentId;
	}

	public boolean isTransferEnabled() {
		return transferEnabled;
	}

	public void setTransferEnabled(boolean transferEnabled) {
		this.transferEnabled = transferEnabled;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("fullName", fullName).append("crypto", crypto)
				.append("payinEnabled", payinEnabled).append("payinPaymentId", payinPaymentId)
				.append("payinConfirmations", payinConfirmations).append("payoutEnabled", payoutEnabled)
				.append("payoutIsPaymentId", payoutIsPaymentId).append("transferEnabled", transferEnabled).toString();
	}

}
