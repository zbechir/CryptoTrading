package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trading.hitbtc.models.TradingBalance;

public interface TradingBalanceRepo extends JpaRepository<TradingBalance,Long> {

}
