package com.genka.cleancommerce.application.controllers;

import com.genka.cleancommerce.application.usecases.auth.dtos.UserSignInInput;
import com.genka.cleancommerce.application.usecases.auth.dtos.UserSignUpInput;
import com.genka.cleancommerce.application.usecases.auth.UserSignIn;
import com.genka.cleancommerce.application.usecases.auth.UserSignUp;
import com.genka.cleancommerce.domain.user.dtos.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final UserSignIn userSignInUseCase;
    private final UserSignUp userSignUpUseCase;

    public AuthController(UserSignIn userSignInUseCase, UserSignUp userSignUpUseCase) {
        this.userSignInUseCase = userSignInUseCase;
        this.userSignUpUseCase = userSignUpUseCase;
    }

    @PostMapping("/signin")
    public ResponseEntity<String> userSignIn(@RequestBody UserSignInInput userSignIpInput) {
        String accessToken = this.userSignInUseCase.execute(userSignIpInput);
        return ResponseEntity.status(HttpStatus.OK).body(accessToken);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> userSignUp(@RequestBody UserSignUpInput userSignUpInput) {
        UserDTO savedUser = this.userSignUpUseCase.execute(userSignUpInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}