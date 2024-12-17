package com.barbosa.hexagonal.adapters.out

import com.barbosa.hexagonal.adapters.out.repository.CustomerRepository
import com.barbosa.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.barbosa.hexagonal.application.core.domain.Customer
import com.barbosa.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    val customerRepository: CustomerRepository
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }

}