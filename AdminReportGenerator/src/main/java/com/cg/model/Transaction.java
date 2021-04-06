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
	private LocalDate dateOfTransaction;
	@Column
	private double profit;
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public double getProfit() {
		return profit;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public Transaction(long transactionId, LocalDate dateOfTransaction, double profit) {
		super();
		this.transactionId = transactionId;
		this.dateOfTransaction = dateOfTransaction;
		this.profit = profit;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
