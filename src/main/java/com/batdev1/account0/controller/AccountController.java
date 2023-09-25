package com.batdev1.account0.controller;


import com.batdev1.account0.dto.AccountDto;
import com.batdev1.account0.dto.CreateAccountRequest;
import com.batdev1.account0.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest request){
        return ResponseEntity.ok(accountService.createAccount(request));
    }
 }
