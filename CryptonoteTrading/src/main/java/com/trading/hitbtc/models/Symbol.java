package com.trading.hitbtc.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Symbol_HITBTC")
public class Symbol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4424666453337246759L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String symbol;
	private Double step;
	private Double lot;
	private String currency;
	private String commodity;
	private Double takeLiquidityRate;
	private Double provideLiquidityRate;

	public Symbol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Symbol(String symbol, Double step, Double lot, String currency, String commodity, Double takeLiquidityRate,
			Double provideLiquidityRate) {
		super();
		this.symbol = symbol;
		this.step = step;
		this.lot = lot;
		this.currency = currency;
		this.commodity = commodity;
		this.takeLiquidityRate = takeLiquidityRate;
		this.provideLiquidityRate = provideLiquidityRate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getStep() {
		return step;
	}

	public void setStep(Double step) {
		this.step = step;
	}

	public Double getLot() {
		return lot;
	}

	public void setLot(Double lot) {
		this.lot = lot;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCommodity() {
		return commodity;
	}

	public void setCommodity(String commodity) {
		this.commodity = commodity;
	}

	public Double getTakeLiquidityRate() {
		return takeLiquidityRate;
	}

	public void setTakeLiquidityRate(Double takeLiquidityRate) {
		this.takeLiquidityRate = takeLiquidityRate;
	}

	public Double getProvideLiquidityRate() {
		return provideLiquidityRate;
	}

	public void setProvideLiquidityRate(Double provideLiquidityRate) {
		this.provideLiquidityRate = provideLiquidityRate;
	}

	@Override
	public String toString() {
		return "Symbol [id=" + id + ", symbol=" + symbol + ", step=" + step + ", lot=" + lot + ", currency=" + currency
				+ ", commodity=" + commodity + ", takeLiquidityRate=" + takeLiquidityRate + ", provideLiquidityRate="
				+ provideLiquidityRate + "]";
	}
}
