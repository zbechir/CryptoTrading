package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trading.hitbtc.models.Symbol;
import com.trading.hitbtc.models.Trade;

public interface TradeRepo extends JpaRepository<Trade, Long> {
	Trade findByTidEquals(long tid);
	Trade findFirstBySymbolOrderByTidDesc(Symbol symbol);
}
