package com.batdev1.account0.dto

import java.math.BigDecimal

data class CreateAccountRequest(
    val customerId: String,
    val initialCredit: BigDecimal
)
