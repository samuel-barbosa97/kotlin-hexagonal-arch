package com.barbosa.hexagonal.application.core.usecase

import com.barbosa.hexagonal.application.core.domain.Customer
import com.barbosa.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.barbosa.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.barbosa.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.barbosa.hexagonal.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase (
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
): InsertCustomerInputPort{

    override fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            insertCustomerOutputPort.insert(it)
            sendCpfForValidationOutputPort.send(it.cpf)
        }
    }
}