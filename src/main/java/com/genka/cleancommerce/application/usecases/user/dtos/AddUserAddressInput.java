package com.genka.cleancommerce.application.usecases.user.dtos;

import com.genka.cleancommerce.domain.address.enums.AddressStatus;
import com.genka.cleancommerce.domain.address.enums.AddressType;

public record AddUserAddressInput(
        String city,
        String complement,
        String contactFullName,
        String contactPhoneNumber,
        String neighborhood,
        String postalCode,
        String state,
        AddressStatus status,
        String street,
        Integer streetNumber,
        AddressType type
) {
}
