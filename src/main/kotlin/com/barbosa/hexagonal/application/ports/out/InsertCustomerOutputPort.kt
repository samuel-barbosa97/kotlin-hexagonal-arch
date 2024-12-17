package com.barbosa.hexagonal.application.ports.out

import com.barbosa.hexagonal.application.core.domain.Customer

interface InsertCustomerOutputPort {

    fun insert(customer: Customer)
}