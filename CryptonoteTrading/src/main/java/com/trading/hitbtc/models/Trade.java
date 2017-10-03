package com.trading.hitbtc.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "Trade_HITBTC")
public class Trade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8945037763991731004L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date date;
	private double price;
	private double amount;
	private long tid;
	private String side;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "symbol_id")
	private Symbol symbol;

	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trade(long id, Date date, double price, double amount, long tid, String side, Symbol symbol) {
		super();
		this.id = id;
		this.date = date;
		this.price = price;
		this.amount = amount;
		this.tid = tid;
		this.side = side;
		this.symbol = symbol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("date", date).append("price", price).append("amount", amount)
				.append("tid", tid).append("side", side).toString();
	}
}
