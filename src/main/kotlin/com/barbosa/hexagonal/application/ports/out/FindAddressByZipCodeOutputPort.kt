package com.barbosa.hexagonal.application.ports.out

import com.barbosa.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun findAddressByZipCode(zipCode: String): Address
}