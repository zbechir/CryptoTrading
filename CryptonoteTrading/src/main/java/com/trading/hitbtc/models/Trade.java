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
@Table(name = "Trade_HITBTC", indexes = { @Index(name = "id_index", columnList = "id") })
public class Trade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8945037763991731004L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long TradeId;
	private Date timestamp;
	private Double price;
	private Double quantity;
	private Long id;
	private String side;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "symbol_id")
	private Symbol symbol;

	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trade(Long tradeId, Date timestamp, Double price, Double quantity, Long id, String side, Symbol symbol) {
		super();
		TradeId = tradeId;
		this.timestamp = timestamp;
		this.price = price;
		this.quantity = quantity;
		this.id = id;
		this.side = side;
		this.symbol = symbol;
	}

	public Long getTradeId() {
		return TradeId;
	}

	public void setTradeId(Long tradeId) {
		TradeId = tradeId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return new ToStringBuilder(this).append("id", id).append("price", price).append("quantity", quantity)
				.append("side", side).append("timestamp", timestamp).toString();
	}
}
