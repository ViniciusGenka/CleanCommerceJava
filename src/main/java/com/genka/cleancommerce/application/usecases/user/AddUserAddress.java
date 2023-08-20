package com.genka.cleancommerce.application.usecases.user;

import com.genka.cleancommerce.application.usecases.user.dtos.AddUserAddressInput;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;

import java.util.UUID;

public interface AddUserAddress {
    AddressDTO execute(UUID userId, AddUserAddressInput addUserAddressInput);
}
