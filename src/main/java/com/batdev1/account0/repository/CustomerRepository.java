package com.batdev1.account0.repository;

import com.batdev1.account0.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
