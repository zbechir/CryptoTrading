package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trading.hitbtc.models.Symbol;

@Repository
public interface SymbolRepo extends JpaRepository<Symbol, Long> {
	Symbol findByIdEquals(String id);
	
}
