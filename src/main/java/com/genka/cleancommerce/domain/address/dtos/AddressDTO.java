package com.genka.cleancommerce.domain.address.dtos;

import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.address.enums.AddressStatus;
import com.genka.cleancommerce.domain.address.enums.AddressType;

import java.util.UUID;

public record AddressDTO(
        UUID id,
        UUID userId,
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
    public AddressDTO(Address address) {
        this(
                address.getId(),
                address.getUserId(),
                address.getCity(),
                address.getComplement(),
                address.getContactFullName(),
                address.getContactPhoneNumber(),
                address.getNeighborhood(),
                address.getPostalCode(),
                address.getState(),
                address.getStatus(),
                address.getStreet(),
                address.getStreetNumber(),
                address.getType()
        );
    }
}
