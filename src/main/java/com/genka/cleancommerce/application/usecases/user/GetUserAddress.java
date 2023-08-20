package com.genka.cleancommerce.application.usecases.user;

import com.genka.cleancommerce.application.usecases.user.dtos.GetUserAddressInput;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;

public interface GetUserAddress {
    AddressDTO execute(GetUserAddressInput getUserAddressInput);
}
