package com.barbosa.hexagonal.adapters.`in`.controller

import com.barbosa.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.barbosa.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.barbosa.hexagonal.application.core.domain.Customer
import com.barbosa.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import com.barbosa.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.barbosa.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val updateCustomerInputPort: UpdateCustomerInputPort,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerInputPort.insert(customer, zipCode)
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CustomerResponse {
        val customer = findCustomerByIdInputPort.find(id)
        return CustomerResponse(customer)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            val customer = Customer(id, name, cpf = cpf)
            updateCustomerInputPort.update(customer, zipCode)
        }
    }
}