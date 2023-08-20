package com.genka.cleancommerce.application.usecases.address;

import com.genka.cleancommerce.application.usecases.address.dtos.GetAddressInput;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;

public interface GetAddress {
    AddressDTO execute(GetAddressInput getAddressInput);
}
