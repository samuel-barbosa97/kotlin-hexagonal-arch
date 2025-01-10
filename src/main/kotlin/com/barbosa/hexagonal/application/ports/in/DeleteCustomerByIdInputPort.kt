package com.barbosa.hexagonal.application.ports.`in`

interface DeleteCustomerByIdInputPort {

    fun delete(id: String)
}