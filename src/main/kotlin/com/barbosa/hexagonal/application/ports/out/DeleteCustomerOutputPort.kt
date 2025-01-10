package com.barbosa.hexagonal.application.ports.out

interface DeleteCustomerOutputPort {

    fun delete(id: String)
}