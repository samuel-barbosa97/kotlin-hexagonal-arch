package com.barbosa.hexagonal.application.core.usecase

import com.barbosa.hexagonal.application.core.domain.Customer
import com.barbosa.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.barbosa.hexagonal.application.ports.out.InsertCustomerOutputPort

class InsertCustomerUseCase (
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort
) {

    fun insert(customer: Customer, zipCode: String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.findAddressByZipCode(zipCode)
        }.let {

        }
    }
}