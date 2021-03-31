package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Aditya Ghogale
 *
 *This class is used to maintain currency value in table
 */

@Entity
public class CurrencyRate {

	//class variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int currId;
	@Column
	private String currency;
	@Column
	private double value;
	
	//para constructor
	public CurrencyRate(int currId, String currency, double value) {
		super();
		this.currId = currId;
		this.currency = currency;
		this.value = value;
	}
	
	//default constructor
	public CurrencyRate() {
		super();
	}
	
	//getters and setters
	public int getCurrId() {
		return currId;
	}
	public void setCurrId(int currId) {
		this.currId = currId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	
	
}
