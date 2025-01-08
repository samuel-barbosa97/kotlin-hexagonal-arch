package com.barbosa.hexagonal.application.ports.out

import com.barbosa.hexagonal.application.core.domain.Customer

interface FindCustomerByIdOutputPort {

    fun find(id: String): Customer?
}