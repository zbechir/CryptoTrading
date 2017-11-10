package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trading.hitbtc.models.Currency;
import com.trading.hitbtc.models.Symbol;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long>{
	Currency findByIdEquals(String id);
}
