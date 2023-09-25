package com.batdev1.account0.service;

import com.batdev1.account0.dto.AccountDto;
import com.batdev1.account0.dto.AccountDtoConverter;
import com.batdev1.account0.dto.CreateAccountRequest;
import com.batdev1.account0.model.Account;
import com.batdev1.account0.model.Customer;
import com.batdev1.account0.model.Transaction;
import com.batdev1.account0.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService,
                          TransactionService transactionService, AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
    }
    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now());


        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0){
           // Transaction transaction = transactionService.initiateMoney(account, createAccountRequest.getInitialCredit());

            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(), account);
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));

    }
}
