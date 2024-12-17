package com.barbosa.hexagonal.adapters.out.repository.entity

import com.barbosa.hexagonal.application.core.domain.Address

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
}
