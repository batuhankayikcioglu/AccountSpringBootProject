package com.batdev1.account0.repository;

import com.batdev1.account0.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
