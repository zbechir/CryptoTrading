package com.trading.hitbtc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trading.hitbtc.models.Balance;
@Repository
public interface BalanceRepo extends JpaRepository<Balance, Long> {

}
