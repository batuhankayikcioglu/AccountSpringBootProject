package com.batdev1.account0.model

import jakarta.persistence.*
import org.hibernate.Transaction
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.GenericGenerator
import org.springframework.cglib.core.Local
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Account(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val balance: BigDecimal? = BigDecimal.ZERO,
    val creationDate: LocalDateTime,
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer?,
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    val transaction: Set<com.batdev1.account0.model.Transaction>? = HashSet()


){

    constructor(customer: Customer, balance: BigDecimal, creationDate: LocalDateTime) : this(
        "",
    customer = customer,
    balance = balance,
    creationDate = creationDate

    )


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Account) return false

        if (id != other.id) return false
        if (balance != other.balance) return false
        if (creationDate != other.creationDate) return false
        if (customer != other.customer) return false
        return transaction == other.transaction
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (balance?.hashCode() ?: 0)
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + (customer?.hashCode() ?: 0)
        return result
    }
}
