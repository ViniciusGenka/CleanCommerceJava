package com.genka.cleancommerce.application.user.usecases;

import com.genka.cleancommerce.application.user.usecases.dtos.GetAllUserAddressesInput;
import com.genka.cleancommerce.application.user.usecases.dtos.GetUserAddressInput;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;

import java.util.List;

public interface GetUserAddress {
    AddressDTO execute(GetUserAddressInput getUserAddressInput);
}
