package com.batdev1.account0.service;

import com.batdev1.account0.model.Account;
import com.batdev1.account0.model.Transaction;
import com.batdev1.account0.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private Logger logger = LoggerFactory.getLogger(TransactionRepository.class);
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount){
        return transactionRepository.save(
                new Transaction(amount, account)
        );
    }

}
