package com.batdev1.account0;


import com.batdev1.account0.model.Customer;
import com.batdev1.account0.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;


@SpringBootApplication
public class Account0Application implements CommandLineRunner {
	private final CustomerRepository customerRepository;

	public Account0Application(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Account0Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer customer = customerRepository.save(new Customer("","Mert","Özler"
		,new HashSet<>()));
		System.out.println(customer);
	}
}
