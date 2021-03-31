package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.CurrencyRate;
import com.cg.service.CurrencyService;

/**
 * 
 * @author Aditya
 *
 */

@RestController
public class AdminController {

	@Autowired
	private CurrencyService service;
	@RequestMapping("/hi")
	public Double sayHi() {
		return 3.142;
	}
	
	@GetMapping("getRate/{currency}")
	public Double getRate(@PathVariable("currency") String currency) {
		CurrencyRate tmpData= service.getRate(currency);
		return tmpData.getValue();
	}
}
