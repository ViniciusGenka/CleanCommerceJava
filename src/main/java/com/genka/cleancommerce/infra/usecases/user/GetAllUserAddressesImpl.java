package com.genka.cleancommerce.infra.usecases.user;

import com.genka.cleancommerce.application.gateways.AddressDatabaseGateway;
import com.genka.cleancommerce.application.usecases.user.GetAllUserAddresses;
import com.genka.cleancommerce.application.usecases.user.dtos.GetAllUserAddressesInput;
import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUserAddressesImpl implements GetAllUserAddresses {
    private final AddressDatabaseGateway addressDatabaseGateway;

    public GetAllUserAddressesImpl(AddressDatabaseGateway addressDatabaseGateway) {
        this.addressDatabaseGateway = addressDatabaseGateway;
    }

    @Override
    public List<AddressDTO> execute(GetAllUserAddressesInput getAllUserAddressesInput) {
        List<Address> addresses = this.addressDatabaseGateway.findByUserId(getAllUserAddressesInput.userId());
        return addresses.stream().map(AddressDTO::new).toList();
    }
}
