package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.cg.model.CurrencyRate;

public interface CurrencyRepository extends JpaRepository<CurrencyRate, Integer> {

	public CurrencyRate findByCurrency(@Param("currency") String currency);
}
