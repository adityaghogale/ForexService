package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.CurrencyRate;
import com.cg.repository.CurrencyRepository;

/**
 * 
 * @author Aditya
 *
 *Service class to access and maintain currency data
 */
@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepo;
	
	public CurrencyRate getRate(String currency) {
		return currencyRepo.findByCurrency(currency);
	}
}
