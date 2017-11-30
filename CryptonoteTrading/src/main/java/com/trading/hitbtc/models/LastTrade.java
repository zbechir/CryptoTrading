package com.trading.hitbtc.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LastTrade_HITBTC", indexes = { @Index(name = "Symbol_index", columnList = "symbol_id") })
public class LastTrade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "symbol_id")
	private Symbol symbol;
	private Long lastTrade;
	
	public LastTrade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LastTrade(Long id, Symbol symbol, Long lastTrade) {
		super();
		this.id = id;
		this.symbol = symbol;
		this.lastTrade = lastTrade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Symbol getSymbol() {
		return symbol;
	}
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	public Long getLastTrade() {
		return lastTrade;
	}
	public void setLastTrade(Long lastTrade) {
		this.lastTrade = lastTrade;
	}
	@Override
	public String toString() {
		return "LastTrade [id=" + id + ", symbol=" + symbol + ", lastTrade=" + lastTrade + "]";
	}
	
	

}
