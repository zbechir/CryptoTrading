package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trading.hitbtc.models.Ticker;
@Repository
public interface TickerRepo extends JpaRepository<Ticker, Long> {

}
