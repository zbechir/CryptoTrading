package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trading.hitbtc.models.LastTrade;
import com.trading.hitbtc.models.Symbol;
@Repository
public interface LastTradeRepo extends JpaRepository<LastTrade, Long> {
	LastTrade findBySymbolEquals(Symbol symbol);

}
