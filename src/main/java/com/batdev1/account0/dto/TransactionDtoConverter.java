package com.batdev1.account0.dto;

import com.batdev1.account0.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public TransactionDto convert(Transaction from){
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
