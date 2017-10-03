package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trading.hitbtc.models.Ticker;

public interface TickerRepo extends JpaRepository<Ticker, Long> {

}
