package com.barbosa.hexagonal.application.ports.`in`

import com.barbosa.hexagonal.application.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer
}