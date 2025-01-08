package com.barbosa.hexagonal.config

import com.barbosa.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.barbosa.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.barbosa.hexagonal.application.ports.`in`.FindCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdAdapter: FindCustomerByIdAdapter): FindCustomerByIdInputPort =
        FindCustomerByIdUseCase(findCustomerByIdAdapter)

}