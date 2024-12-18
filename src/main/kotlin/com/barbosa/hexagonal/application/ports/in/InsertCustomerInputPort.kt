package com.barbosa.hexagonal.application.ports.`in`

import com.barbosa.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)
}