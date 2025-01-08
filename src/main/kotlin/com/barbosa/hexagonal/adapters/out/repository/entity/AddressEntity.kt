package com.barbosa.hexagonal.adapters.out.repository.entity

import com.barbosa.hexagonal.application.core.domain.Address
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Add

data class AddressEntity(
    val street: String,
    val city: String,
    val state: String,
) {
    constructor(address: Address) : this(
        street = address.street,
        city = address.city,
        state = address.state,
    )

    fun toAddress() = Address(street, city, state)
}
