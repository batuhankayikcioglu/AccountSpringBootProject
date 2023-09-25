package com.batdev1.account0.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.temporal.TemporalAmount

@Entity

data class Transaction(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String?,
    val transactionType: TransactionType? = TransactionType.INITIAL,
    val amount: BigDecimal?,
    val transactionDate: LocalDateTime?,
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    val account: Account

){

    constructor(amount: BigDecimal, account: Account): this(
        id= null,
        amount = amount,
        transactionDate = LocalDateTime.now(),
        transactionType = TransactionType.INITIAL,
        account = account
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Transaction) return false

        if (id != other.id) return false
        if (transactionType != other.transactionType) return false
        if (amount != other.amount) return false
        if (transactionDate != other.transactionDate) return false
        return account == other.account
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (transactionType?.hashCode() ?: 0)
        result = 31 * result + (amount?.hashCode() ?: 0)
        result = 31 * result + (transactionDate?.hashCode() ?: 0)
        result = 31 * result + account.hashCode()
        return result
    }
}

enum class TransactionType{
    INITIAL, TRANSFER
}