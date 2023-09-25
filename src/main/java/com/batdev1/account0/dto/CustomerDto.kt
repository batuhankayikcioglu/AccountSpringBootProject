package com.batdev1.account0.dto

data class CustomerDto(
    val id: String,
    val name: String,
    val surname: String,
    val accounts: Set<CustomerAccountDto>
) {
}