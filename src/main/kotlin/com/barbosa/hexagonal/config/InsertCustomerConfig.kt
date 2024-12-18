package com.barbosa.hexagonal.config

import com.barbosa.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.barbosa.hexagonal.adapters.out.InsertCustomerAdapter
import com.barbosa.hexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter
    ) = InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter)
}