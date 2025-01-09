package com.barbosa.hexagonal.config

import com.barbosa.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.barbosa.hexagonal.adapters.out.UpdateCustomerAdapter
import com.barbosa.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.barbosa.hexagonal.application.core.usecase.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter
    ) = UpdateCustomerUseCase(
            findCustomerByIdUseCase,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter
    )
}