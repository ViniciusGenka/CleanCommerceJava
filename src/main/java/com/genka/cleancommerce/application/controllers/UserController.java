package com.genka.cleancommerce.application.controllers;

import com.genka.cleancommerce.application.usecases.user.AddUserAddress;
import com.genka.cleancommerce.application.usecases.user.GetAllUserAddresses;
import com.genka.cleancommerce.application.usecases.user.GetUserAddress;
import com.genka.cleancommerce.application.usecases.user.GetUserProfile;
import com.genka.cleancommerce.application.usecases.user.dtos.*;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;
import com.genka.cleancommerce.domain.user.dtos.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    private final AddUserAddress addUserAddressUseCase;
    private final GetAllUserAddresses getAllUserAddressesUseCase;
    private final GetUserAddress getUserAddressUseCase;
    private final GetUserProfile getUserProfileUseCase;

    public UserController(AddUserAddress addUserAddressUseCase, GetAllUserAddresses getAllUserAddressesUseCase, GetUserAddress getUserAddressUseCase, GetUserProfile getUserProfileUseCase) {
        this.addUserAddressUseCase = addUserAddressUseCase;
        this.getAllUserAddressesUseCase = getAllUserAddressesUseCase;
        this.getUserAddressUseCase = getUserAddressUseCase;
        this.getUserProfileUseCase = getUserProfileUseCase;
    }

    @PostMapping("/{id}/addresses")
    public ResponseEntity<AddressDTO> addUserAddress(@PathVariable UUID id, @RequestBody AddUserAddressInput addUserAddressInput) {
        AddressDTO savedAddresses = this.addUserAddressUseCase.execute(id, addUserAddressInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddresses);
    }

    @GetMapping("/{id}/addresses")
    public ResponseEntity<List<AddressDTO>> getAllUserAddresses(@PathVariable UUID id) {
        List<AddressDTO> addresses = this.getAllUserAddressesUseCase.execute(new GetAllUserAddressesInput(id));
        return ResponseEntity.status(HttpStatus.OK).body(addresses);
    }

    @GetMapping("/{userId}/addresses/{addressId}")
    public ResponseEntity<AddressDTO> getUserAddress(@PathVariable UUID userId, @PathVariable UUID addressId) {
        AddressDTO address = this.getUserAddressUseCase.execute(new GetUserAddressInput(addressId, userId));
        return ResponseEntity.status(HttpStatus.OK).body(address);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable UUID id) {
        UserDTO user = this.getUserProfileUseCase.execute(new GetUserProfileInput(id));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
