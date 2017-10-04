package com.trading.hitbtc.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
@Entity
@Table(name="Balance_HITBTC", indexes= {@Index(name="currency_index", columnList="currencyCode")})
public class Balance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4601442261486732975L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String currencyCode;
	private Double cash;
	private Double reserved;
	private Date date;
	
	public Balance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Balance(long id, String currencyCode, Double cash, Double reserved, Date date) {
		super();
		this.id = id;
		this.currencyCode = currencyCode;
		this.cash = cash;
		this.reserved = reserved;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Double getCash() {
		return cash;
	}

	public void setCash(Double cash) {
		this.cash = cash;
	}

	public Double getReserved() {
		return reserved;
	}

	public void setReserved(Double reserved) {
		this.reserved = reserved;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("currencyCode", currencyCode).append("cash", cash)
				.append("reserved", reserved).append("Date", date).toString();
	}

}
