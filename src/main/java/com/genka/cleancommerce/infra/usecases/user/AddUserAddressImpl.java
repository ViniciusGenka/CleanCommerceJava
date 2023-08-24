package com.genka.cleancommerce.infra.usecases.user;

import com.genka.cleancommerce.application.gateways.AddressDatabaseGateway;
import com.genka.cleancommerce.application.usecases.user.AddUserAddress;
import com.genka.cleancommerce.application.usecases.user.dtos.AddUserAddressInput;
import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;
import com.genka.cleancommerce.domain.address.enums.AddressStatus;
import com.genka.cleancommerce.domain.address.enums.AddressType;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
                AddressStatus.ACTIVE,
                addUserAddressInput.street(),
                addUserAddressInput.streetNumber(),
                AddressType.RESIDENTIAL
        );
        Address savedAddress = this.addressDatabaseGateway.save(address);
        return new AddressDTO(savedAddress);
    }
}
