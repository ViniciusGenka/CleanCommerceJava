package com.genka.cleancommerce.infra.user.usecases;

import com.genka.cleancommerce.application.address.gateways.AddressDatabaseGateway;
import com.genka.cleancommerce.application.exceptions.EntityNotFoundException;
import com.genka.cleancommerce.application.user.usecases.GetUserAddress;
import com.genka.cleancommerce.application.user.usecases.dtos.GetUserAddressInput;
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
