package com.barbosa.hexagonal.application.ports.out

interface SendCpfForValidationOutputPort {

    fun send(cpf: String)
}