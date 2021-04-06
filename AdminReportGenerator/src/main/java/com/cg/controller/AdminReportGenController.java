package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.InvalidRequestException;
import com.cg.model.EntityReport;
import com.cg.model.ReportData;
import com.cg.model.Transaction;
import com.cg.service.DataReportService;
import com.cg.service.TransactionService;

/**
 * 
 * @author Aditya Ghogale
 *
 *Controller for report generation microservice
 */

@RestController
@CrossOrigin(origins = { "http://localhost:3000"}, allowCredentials = "false")
public class AdminReportGenController {

	//Instance of transaction service
	@Autowired
	private TransactionService service;
	
	//Instance of data report service 
	@Autowired
	private DataReportService dataReportService;
	
	//to add new transaction into table
	// for data testing only
	@PostMapping("addTransaction")
	public Transaction addTransaction(@RequestBody Transaction ts) {
		Transaction tmpTransaction=new Transaction(ts.getTransactionId(),ts.getDateOfTransaction(),ts.getProfit());
		return service.addTransaction(tmpTransaction);
	}
	
	//get list of transactions done on specific date
	@GetMapping("getTransaction/{date}")
	public List<Transaction> getTransaction(@PathVariable String date) throws InvalidRequestException {
		LocalDate localDate = LocalDate.parse(date);
		
		//check if requested date should be between 01/01/2020 and todays date
		if(localDate.compareTo(LocalDate.now())>0 || localDate.compareTo(LocalDate.of(2020, 01, 01))<0)
			throw new InvalidRequestException("Invalid date for report");
		return (List<Transaction>) service.getTransaction(localDate);
	}
	
	//get all transaction for a specific year
	@GetMapping("getTransactionByYear/{year}")
	public List<Transaction> getTransaction(@PathVariable int year) throws InvalidRequestException {
		if(year<2020 || year>2021)
			throw new InvalidRequestException("Invalid Year");
		return (List<Transaction>) service.findByYear(year);
	}
	
	//get yearly report of profit
	@GetMapping("getYearlyReport")
	public List<ReportData> getYearlyReport(){
		return service.getYearlyReport();	
	}
	
	//get monthly report of profit for a specific year
	@GetMapping("getMonthlyReport/{year}")
	public List<ReportData> getMonthlyReport(@PathVariable int year) throws InvalidRequestException{
			if(year<2020 || year>2021)
				throw new InvalidRequestException("Invalid Year");		
		return service.getMonthlyReport(year);	
		
	}
	
	//get day wise report for a specific month
	@GetMapping("getDayWiseReport/{month}/{year}")
	public List<ReportData> getDayWiseReport(@PathVariable int month,@PathVariable int year) throws InvalidRequestException{
		if(year<2020 || year>2021)
			throw new InvalidRequestException("Invalid Year");
		if(month<1 || month>12)
			throw new InvalidRequestException("Invalid Month");
		return service.getDayWiseReportForMonth(month,year);
	}
	
	//to get most send currency
	@RequestMapping("/getMostUsedSenderCurrency")
	public EntityReport getMostUsedSenderCurrency() {
		return dataReportService.getMostUsedSenderCurrency();
	}
	
	//to get most receiver currency
		@RequestMapping("/getMostUsedReceiverCurrency")
		public EntityReport getMostUsedReceiverCurrency() {
			return dataReportService.getMostUsedReceiverCurrency();
		}
		
		
	//to get most frequent username
		@RequestMapping("/getMostFrequentUser")
		public EntityReport getMostFrequentUser() {
			return dataReportService.getMostFrequentUserName();
		}
		
}
