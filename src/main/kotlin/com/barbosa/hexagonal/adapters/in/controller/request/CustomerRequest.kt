package com.barbosa.hexagonal.adapters.`in`.controller.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(
    @field:NotBlank(message = "Name cannot be blank")
    val name: String,
    @field:NotBlank(message = "CPF cannot be blank")
    val cpf: String,
    @field:NotBlank(message = "ZipCode cannot be blank")
    val zipCode: String
)
