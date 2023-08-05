package com.genka.cleancommerce.application.address.usecases;

import com.genka.cleancommerce.application.address.usecases.dtos.GetAddressInput;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;

public interface GetAddress {
    AddressDTO execute(GetAddressInput getAddressInput);
}
