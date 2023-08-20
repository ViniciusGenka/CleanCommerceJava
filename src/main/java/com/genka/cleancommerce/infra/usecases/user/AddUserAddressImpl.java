package com.genka.cleancommerce.infra.usecases.user;

import com.genka.cleancommerce.application.gateways.AddressDatabaseGateway;
import com.genka.cleancommerce.application.usecases.user.AddUserAddress;
import com.genka.cleancommerce.application.usecases.user.dtos.AddUserAddressInput;
import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddUserAddressImpl implements AddUserAddress {
    private final AddressDatabaseGateway addressDatabaseGateway;

    public AddUserAddressImpl(AddressDatabaseGateway addressDatabaseGateway) {
        this.addressDatabaseGateway = addressDatabaseGateway;
    }

    @Override
    public AddressDTO execute(UUID userId, AddUserAddressInput addUserAddressInput) {
        Address address = new Address(
                userId,
                addUserAddressInput.city(),
                addUserAddressInput.complement(),
                addUserAddressInput.contactFullName(),
                addUserAddressInput.contactPhoneNumber(),
                addUserAddressInput.neighborhood(),
                addUserAddressInput.postalCode(),
                addUserAddressInput.state(),
                addUserAddressInput.status(),
                addUserAddressInput.street(),
                addUserAddressInput.streetNumber(),
                addUserAddressInput.type()
        );
        Address savedAddress = this.addressDatabaseGateway.save(address);
        return new AddressDTO(savedAddress);
    }
}
