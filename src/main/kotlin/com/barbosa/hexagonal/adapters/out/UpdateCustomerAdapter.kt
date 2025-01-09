package com.barbosa.hexagonal.adapters.out

import com.barbosa.hexagonal.adapters.out.repository.CustomerRepository
import com.barbosa.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.barbosa.hexagonal.application.core.domain.Customer
import com.barbosa.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository
) : UpdateCustomerOutputPort {

    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}