package com.barbosa.hexagonal.application.core.usecase

import com.barbosa.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.barbosa.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.barbosa.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
) : FindCustomerByIdInputPort {

    override fun find(id: String) =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("$id is not found")
}