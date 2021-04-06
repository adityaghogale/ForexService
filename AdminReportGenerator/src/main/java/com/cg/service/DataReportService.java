package com.cg.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.EntityReport;
import com.cg.repository.DummyTranscRepository;

/**
 * 
 * @author Aditya
 *
 */

@Service
public class DataReportService {

	//Dummy Transaction repository object
	@Autowired
	private DummyTranscRepository repo;
	
	//to get currency used mostly to send money
	public EntityReport getMostUsedSenderCurrency() {
		return repo.getMostUsedSenderCurrency().get(0);
	}
	
	//to get currency used mostly to receive money
	public EntityReport getMostUsedReceiverCurrency() {
		return repo.getMostUsedReceiverCurrency().get(0);
	}
	
	//to get most frequent user
	public EntityReport getMostFrequentUserName() {
		return repo.getMostFrequentUserName().get(0);	
	}
}
