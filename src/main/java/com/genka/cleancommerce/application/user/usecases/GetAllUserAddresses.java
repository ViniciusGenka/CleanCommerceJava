package com.genka.cleancommerce.application.user.usecases;

import com.genka.cleancommerce.application.user.usecases.dtos.GetAllUserAddressesInput;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;

import java.util.List;

public interface GetAllUserAddresses {
    List<AddressDTO> execute(GetAllUserAddressesInput getAllUserAddressesInput);
}
