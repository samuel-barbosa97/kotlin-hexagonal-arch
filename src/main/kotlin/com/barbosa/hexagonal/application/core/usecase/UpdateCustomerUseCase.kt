package com.barbosa.hexagonal.application.core.usecase

import com.barbosa.hexagonal.application.core.domain.Customer
import com.barbosa.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.barbosa.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.barbosa.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.barbosa.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException("Customer ID cannot be null")
        findCustomerByIdInputPort.find(customer.id)

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
        }
    }
}