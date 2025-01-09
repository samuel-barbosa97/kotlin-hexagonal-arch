package com.barbosa.hexagonal.application.ports.`in`

import com.barbosa.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)
}