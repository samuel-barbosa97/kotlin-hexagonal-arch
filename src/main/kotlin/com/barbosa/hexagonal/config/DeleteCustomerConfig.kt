package com.barbosa.hexagonal.config

import com.barbosa.hexagonal.adapters.out.DeleteCustomerByIdAdapter
import com.barbosa.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import com.barbosa.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeleteCustomerConfig {

    @Bean
    fun deleteCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdAdapter: DeleteCustomerByIdAdapter
    ) = DeleteCustomerByIdUseCase(
        findCustomerByIdUseCase,
        deleteCustomerByIdAdapter
    )
}
