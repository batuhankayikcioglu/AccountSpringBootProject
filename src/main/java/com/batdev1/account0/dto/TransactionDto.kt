package com.batdev1.account0.dto

import com.batdev1.account0.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(
    val id: String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?
) {
}