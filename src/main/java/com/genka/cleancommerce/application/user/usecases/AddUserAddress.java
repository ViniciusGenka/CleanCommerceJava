package com.genka.cleancommerce.application.user.usecases;

import com.genka.cleancommerce.application.user.usecases.dtos.AddUserAddressInput;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;

import java.util.UUID;

public interface AddUserAddress {
    AddressDTO execute(UUID userId, AddUserAddressInput addUserAddressInput);
}
