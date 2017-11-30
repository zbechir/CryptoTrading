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
@Entity
@Table(name = "TradingFee_HITBTC",  indexes= {@Index(name="currency_index", columnList="currency_id")})
public class TradingFee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "currency_id")
	private Currency currency;
	private String takeLiquidityRate;
	private String provideLiquidityRate;
	
	public TradingFee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TradingFee(Long id, Currency currency, String takeLiquidityRate, String provideLiquidityRate) {
		super();
		Id = id;
		this.currency = currency;
		this.takeLiquidityRate = takeLiquidityRate;
		this.provideLiquidityRate = provideLiquidityRate;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
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
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("takeLiquidityRate", takeLiquidityRate)
				.append("provideLiquidityRate", provideLiquidityRate)
				.append("Currency", currency).toString();
	}
}
