package com.barbosa.hexagonal.application.core.usecase

import com.barbosa.hexagonal.application.core.domain.Customer
import com.barbosa.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.barbosa.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
) {

    fun find(id: String): Customer {
        return findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("$id is not found")
    }
}