package com.barbosa.hexagonal.application.core.usecase

import com.barbosa.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.barbosa.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.barbosa.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
) : DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerByIdOutputPort.delete(id)
    }
}