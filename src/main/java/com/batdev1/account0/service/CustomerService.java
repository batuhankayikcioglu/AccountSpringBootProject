package com.batdev1.account0.service;

import com.batdev1.account0.exception.CustomerNotFoundException;
import com.batdev1.account0.model.Customer;
import com.batdev1.account0.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    protected Customer findCustomerById(String id){
        return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException
                ("Customer could not findy by id" + id));
    }
}
