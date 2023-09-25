package com.batdev1.account0.dto

import com.batdev1.account0.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(
    val id: String?,
    val balance: BigDecimal?,
    val creationDate: LocalDateTime,
    val customer: AccountCustomerDto?,
    val transactions: Set<TransactionDto>?
){

}
