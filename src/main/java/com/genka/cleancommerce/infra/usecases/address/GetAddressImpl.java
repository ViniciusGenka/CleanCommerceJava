package com.genka.cleancommerce.infra.usecases.address;

import com.genka.cleancommerce.application.gateways.AddressDatabaseGateway;
import com.genka.cleancommerce.application.usecases.address.GetAddress;
import com.genka.cleancommerce.application.usecases.address.dtos.GetAddressInput;
import com.genka.cleancommerce.application.exceptions.EntityNotFoundException;
import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;
import org.springframework.stereotype.Service;

@Service
public class GetAddressImpl implements GetAddress {

    private final AddressDatabaseGateway addressDatabaseGateway;

    public GetAddressImpl(AddressDatabaseGateway addressDatabaseGateway) {
        this.addressDatabaseGateway = addressDatabaseGateway;
    }

    @Override
    public AddressDTO execute(GetAddressInput getAddressInput) {
        Address address = this.addressDatabaseGateway.findById(getAddressInput.id()).orElseThrow(() -> new EntityNotFoundException("Address not found"));
        return new AddressDTO(address);
    }
}
