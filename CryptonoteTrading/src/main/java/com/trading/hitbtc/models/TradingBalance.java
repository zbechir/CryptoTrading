package com.trading.hitbtc.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "TradingBalance_HITBTC",  indexes= {@Index(name="currency_index", columnList="currency_id")})
public class TradingBalance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4601442261486732975L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "currency_id")
	private Currency currency;
	private Double available;
	private Double reserved;
	private Date timestamp;

	public TradingBalance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradingBalance(Long id, Currency currency, Double available, Double reserved, Date timestamp) {
		super();
		this.id = id;
		this.currency = currency;
		this.available = available;
		this.reserved = reserved;
		this.timestamp = timestamp;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getAvailable() {
		return available;
	}

	public void setAvailable(Double available) {
		this.available = available;
	}

	public Double getReserved() {
		return reserved;
	}

	public void setReserved(Double reserved) {
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("currency", currency).append("available", available)
				.append("reserved", reserved).append("Date", timestamp).toString();
	}
}
