package com.barbosa.hexagonal.application.ports.out

import com.barbosa.hexagonal.application.core.domain.Customer

interface UpdateCustomerOutputPort {

    fun update(customer: Customer)
}