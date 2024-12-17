package com.barbosa.hexagonal.adapters.out

import com.barbosa.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.barbosa.hexagonal.application.core.domain.Address
import com.barbosa.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
) : FindAddressByZipCodeOutputPort {

    override fun findAddressByZipCode(zipCode: String): Address =
        findAddressByZipCodeClient.findAddressByZipCode(zipCode).toAddress()
}