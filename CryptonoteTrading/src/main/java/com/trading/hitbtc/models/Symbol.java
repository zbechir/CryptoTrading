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

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Symbol_HITBTC", indexes = { @Index(name = "symbol_index", columnList = "id") })
public class Symbol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4424666453337246759L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long SymbolId;
	private String id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "baseCurrency_id")
	private Currency baseCurrency;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "quoteCurrency_id")
	private Currency quoteCurrency;
	private String quantityIncrement;
	private String tickSize;
	private String takeLiquidityRate;
	private String provideLiquidityRate;
	private String feeCurrency;

	public Symbol() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Symbol(long symbolId, String id, Currency baseCurrency, Currency quoteCurrency, String quantityIncrement,
			String tickSize, String takeLiquidityRate, String provideLiquidityRate, String feeCurrency) {
		super();
		SymbolId = symbolId;
		this.id = id;
		this.baseCurrency = baseCurrency;
		this.quoteCurrency = quoteCurrency;
		this.quantityIncrement = quantityIncrement;
		this.tickSize = tickSize;
		this.takeLiquidityRate = takeLiquidityRate;
		this.provideLiquidityRate = provideLiquidityRate;
		this.feeCurrency = feeCurrency;
	}



	public long getSymbolId() {
		return SymbolId;
	}



	public void setSymbolId(long symbolId) {
		SymbolId = symbolId;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Currency getBaseCurrency() {
		return baseCurrency;
	}



	public void setBaseCurrency(Currency baseCurrency) {
		this.baseCurrency = baseCurrency;
	}



	public Currency getQuoteCurrency() {
		return quoteCurrency;
	}



	public void setQuoteCurrency(Currency quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
	}



	public String getQuantityIncrement() {
		return quantityIncrement;
	}



	public void setQuantityIncrement(String quantityIncrement) {
		this.quantityIncrement = quantityIncrement;
	}



	public String getTickSize() {
		return tickSize;
	}



	public void setTickSize(String tickSize) {
		this.tickSize = tickSize;
	}



	public String getTakeLiquidityRate() {
		return takeLiquidityRate;
	}



	public void setTakeLiquidityRate(String takeLiquidityRate) {
		this.takeLiquidityRate = takeLiquidityRate;
	}



	public String getProvideLiquidityRate() {
		return provideLiquidityRate;
	}



	public void setProvideLiquidityRate(String provideLiquidityRate) {
		this.provideLiquidityRate = provideLiquidityRate;
	}



	public String getFeeCurrency() {
		return feeCurrency;
	}



	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("baseCurrency", baseCurrency)
				.append("quoteCurrency", quoteCurrency).append("quantityIncrement", quantityIncrement)
				.append("tickSize", tickSize).append("takeLiquidityRate", takeLiquidityRate)
				.append("provideLiquidityRate", provideLiquidityRate).append("feeCurrency", feeCurrency).toString();
	}
}
