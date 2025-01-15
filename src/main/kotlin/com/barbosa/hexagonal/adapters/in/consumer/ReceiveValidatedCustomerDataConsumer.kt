package com.barbosa.hexagonal.adapters.`in`.consumer

import com.barbosa.hexagonal.adapters.`in`.consumer.message.CustomerMessage
import com.barbosa.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener

class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "hexagonal")

    fun receive(customerMessage: CustomerMessage) {
        with(customerMessage) {
            updateCustomerInputPort.update(toCustomer(), zipCode)
        }
    }
}