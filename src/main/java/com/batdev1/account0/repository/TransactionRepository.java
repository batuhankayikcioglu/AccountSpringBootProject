package com.batdev1.account0.repository;

import com.batdev1.account0.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
