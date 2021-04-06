package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.model.DummyTransacData;
import com.cg.model.EntityReport;

/**
 * 
 * @author Aditya Ghogale
 *
 */
public interface DummyTranscRepository extends JpaRepository<DummyTransacData, Long> {

	//to get most used currency
	//SELECT from_curr as EntityName FROM dummy_transac_data d group by from_curr order by count(from_curr) DESC;
	
	@Query(value="SELECT from_curr as EntityName FROM dummy_transac_data d group by from_curr order by count(from_curr) DESC",nativeQuery = true)
	public List<EntityReport> getMostUsedSenderCurrency();
	

	//to get most used currency
	//SELECT to_curr as EntityName FROM dummy_transac_data d group by to_curr order by count(to_curr) DESC;
	
	@Query(value="SELECT to_curr as EntityName FROM dummy_transac_data d group by to_curr order by count(to_curr) DESC",nativeQuery = true)
	public List<EntityReport> getMostUsedReceiverCurrency();
	
	

	//to get most frequent user
	//SELECT from_user as EntityName FROM dummy_transac_data d group by from_user order by count(from_user) DESC;
	
	@Query(value="SELECT from_user as EntityName FROM dummy_transac_data d group by from_user order by count(from_user) DESC",nativeQuery = true)
	public List<EntityReport> getMostFrequentUserName();
}
