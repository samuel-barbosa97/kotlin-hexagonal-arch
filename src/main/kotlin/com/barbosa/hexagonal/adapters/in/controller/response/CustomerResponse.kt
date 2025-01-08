package com.barbosa.hexagonal.adapters.`in`.controller.response

import com.barbosa.hexagonal.application.core.domain.Customer

data class CustomerResponse(
    val id: String,
    val name: String,
    val address: AddressResponse,
    val cpf: String,
    val isValidCpf: Boolean
) {

    constructor(customer: Customer) : this(
        customer.id!!,
        customer.name,
        AddressResponse(customer.address!!),
        customer.cpf,
        customer.isValidCpf
    )
}