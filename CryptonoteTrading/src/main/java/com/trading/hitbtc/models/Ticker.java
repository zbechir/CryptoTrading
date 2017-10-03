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

import com.trading.hitbtc.models.Symbol;


@Entity
@Table(name="Ticker_HITBTC")
public class Ticker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2210302680342690499L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Double ask;
	private Double bid;
	private Double last;
	private Double low;
	private Double high;
	private Double open;
	private Double volume;
	private Double volumeQuote;
	private Date timestamp;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "symbol_id")
	private Symbol symbol;
	
	public Ticker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ticker(Double ask, Double bid, Double last, Double low, Double high, Double open, Double volume,
			Double volumeQuote, Date timestamp, Symbol symbol) {
		super();
		this.ask = ask;
		this.bid = bid;
		this.last = last;
		this.low = low;
		this.high = high;
		this.open = open;
		this.volume = volume;
		this.volumeQuote = volumeQuote;
		this.timestamp = timestamp;
		this.symbol = symbol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getAsk() {
		return ask;
	}

	public void setAsk(Double ask) {
		this.ask = ask;
	}

	public Double getBid() {
		return bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}

	public Double getLast() {
		return last;
	}

	public void setLast(Double last) {
		this.last = last;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getVolumeQuote() {
		return volumeQuote;
	}

	public void setVolumeQuote(Double volumeQuote) {
		this.volumeQuote = volumeQuote;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Ticker [id=" + id + ", ask=" + ask + ", bid=" + bid + ", last=" + last + ", low=" + low + ", high="
				+ high + ", open=" + open + ", volume=" + volume + ", volumeQuote=" + volumeQuote + ", timestamp="
				+ timestamp + ", symbol=" + symbol + "]";
	}
	
	
}
