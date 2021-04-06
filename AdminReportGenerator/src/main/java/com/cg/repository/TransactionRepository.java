package com.cg.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.model.ReportData;
import com.cg.model.Transaction;

/**
 * 
 * @author Aditya Ghogale
 *
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	//to fetch list of transactions on particular date
	public List<Transaction> findByDateOfTransaction(@Param("date") LocalDate date);
	
	//to fetch all transaction for a sepcific year
	@Query("select t from Transaction t where Year(t.dateOfTransaction)=:year")
	public List<Transaction> findByYear(@Param("year") int year);
	
	//to fetch profit of all year
	//SELECT Year(date_of_transaction),sum(profit) FROM `transaction` t group by Year(date_of_transaction);
	@Query(value="SELECT Year(t.date_of_transaction) as ReportType,sum(t.profit) as prof  FROM transaction t group by Year(t.date_of_transaction)",nativeQuery = true)
	public List<ReportData> getYearlyReport();
	
	//to fetch month wise 
	//SELECT Concat_WS("/",Month(date_of_transaction),Year(date_of_transaction)) as "month/year",sum(profit) FROM `transaction` t group by Month(date_of_transaction);
	@Query(value="SELECT Concat_WS(\"/\",Month(date_of_transaction),Year(date_of_transaction)) as ReportType,sum(profit) as prof FROM transaction t where Year(t.date_Of_Transaction)=:year group by Month(date_of_transaction)",nativeQuery = true)
	public List<ReportData> getMonthlyReport(@Param("year") int year);
	
	
	//to fetch daily profit
	@Query(value="Select date_of_transaction as ReportType,sum(profit) as prof FROM transaction t where Month(t.date_Of_Transaction)=:month AND YEAR(t.date_Of_Transaction)=:year group by t.date_of_transaction",nativeQuery = true)
	public List<ReportData> getDayWiseReportForMonth(@Param("month") int month,@Param("year") int year);
}
