package com.genka.cleancommerce.application.usecases.user;

import com.genka.cleancommerce.application.usecases.user.dtos.GetAllUserAddressesInput;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;

import java.util.List;

public interface GetAllUserAddresses {
    List<AddressDTO> execute(GetAllUserAddressesInput getAllUserAddressesInput);
}
