package com.genka.cleancommerce.application.address.gateways;

import com.genka.cleancommerce.domain.address.Address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AddressDatabaseGateway {
    Address save(Address address);

    Optional<Address> findById(UUID id);

    Optional<Address> findByIdAndUserId(UUID id, UUID userId);

    List<Address> findByUserId(UUID id);
}
