package com.genka.cleancommerce.infra.usecases.user;

import com.genka.cleancommerce.application.gateways.AddressDatabaseGateway;
import com.genka.cleancommerce.application.exceptions.EntityNotFoundException;
import com.genka.cleancommerce.application.usecases.user.GetUserAddress;
import com.genka.cleancommerce.application.usecases.user.dtos.GetUserAddressInput;
import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;
import org.springframework.stereotype.Service;

@Service
public class GetUserAddressImpl implements GetUserAddress {
    private final AddressDatabaseGateway addressDatabaseGateway;

    public GetUserAddressImpl(AddressDatabaseGateway addressDatabaseGateway) {
        this.addressDatabaseGateway = addressDatabaseGateway;
    }

    @Override
    public AddressDTO execute(GetUserAddressInput getUserAddressInput) {
        Address address = this.addressDatabaseGateway.findByIdAndUserId(getUserAddressInput.addressId(), getUserAddressInput.userId()).orElseThrow(() -> new EntityNotFoundException("Address not found"));
        return new AddressDTO(address);
    }
}
