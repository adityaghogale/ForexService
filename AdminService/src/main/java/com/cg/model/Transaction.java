package com.cg.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Aditya Ghogale
 *
 *Model class for transaction table
 */
@Entity
public class Transaction {

	//instance variables
	@Id
	private long transactionId;
	@Column
	private String fromCurrency;
	@Column
	private String toCurrency;
	@Column
	private String sender;
	@Column
	private String receiver;
	@Column
	private LocalDate dateOfTransaction;
	@Column
	private double amount;
	@Column
	private double profit;
	
	//constructors
	public Transaction(long transactionId, String fromCurrency, String toCurrency, String sender, String receiver,
			LocalDate dateOfTransaction, double amount) {
		super();
		this.transactionId = transactionId;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.sender = sender;
		this.receiver = receiver;
		this.dateOfTransaction = dateOfTransaction;
		this.amount = amount;
	}
	public Transaction() {
		super();
	}
	
	
	//getters and setters
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

	
	
	
	
}
