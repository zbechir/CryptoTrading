package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trading.hitbtc.models.Symbol;
import com.trading.hitbtc.models.Trade;
@Repository
public interface TradeRepo extends JpaRepository<Trade, Long> {
	Trade findByTidEquals(long tid);
	Trade findFirstBySymbolOrderByTidDesc(Symbol symbol);
}
