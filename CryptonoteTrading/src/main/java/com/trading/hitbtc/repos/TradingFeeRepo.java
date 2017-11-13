package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trading.hitbtc.models.TradingFee;

public interface TradingFeeRepo extends JpaRepository<TradingFee, Long>{
	

}
