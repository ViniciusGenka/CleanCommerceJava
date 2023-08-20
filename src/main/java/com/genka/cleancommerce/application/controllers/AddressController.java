package com.genka.cleancommerce.application.controllers;

import com.genka.cleancommerce.application.usecases.address.GetAddress;
import com.genka.cleancommerce.application.usecases.address.dtos.GetAddressInput;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("addresses")
public class AddressController {
    private final GetAddress getAddressUseCase;

    public AddressController(GetAddress getAddressUseCase) {
        this.getAddressUseCase = getAddressUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable UUID id) {
        AddressDTO address = this.getAddressUseCase.execute(new GetAddressInput(id));
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }
}
