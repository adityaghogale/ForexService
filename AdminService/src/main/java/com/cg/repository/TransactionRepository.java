package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}

