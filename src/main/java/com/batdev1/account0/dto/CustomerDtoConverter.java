package com.batdev1.account0.dto;


import com.batdev1.account0.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    public AccountCustomerDto convertToAccountCustomer(Customer from){
        if (from == null){
            return new AccountCustomerDto("","","");
        }
        return new AccountCustomerDto(from.getId(), from.getName(), from.getSurname());
    }

}
