package com.cg.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.ReportData;
import com.cg.model.Transaction;
import com.cg.repository.TransactionRepository;

/**
 * 
 * @author Aditya
 *
 *Service class to access and maintain currency data
 */
@Service
public class TransactionService {

	//instance of transaction repository
	@Autowired
	private TransactionRepository transactionRepo;
	
	
	//to add new transaction
	public Transaction addTransaction(Transaction ts) {
		return transactionRepo.save(ts);
	}
	
	
	//to get list of transactions on particular day
	public List<Transaction> getTransaction(LocalDate date) {
		return (List<Transaction>) transactionRepo.findByDateOfTransaction(date);
	}
	
	//to find specific transaction by ID
	public Transaction findById(Long id) {
		return transactionRepo.findById(id).get();
	}
	
	//find all transactions done on specific year
	public List<Transaction> findByYear(int year){
		return transactionRepo.findByYear(year);
	}
	
	//to get yearly report of profit
	public List<ReportData> getYearlyReport(){
		return transactionRepo.getYearlyReport();
	}
	
	//to get monthly report of profit
	public List<ReportData> getMonthlyReport(int year){
		return transactionRepo.getMonthlyReport(year);
	}
	
	//to get daily report of profit
	public List<ReportData> getDayWiseReportForMonth(int month,int year){
		return transactionRepo.getDayWiseReportForMonth(month,year);
	}
}
