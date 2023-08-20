package com.genka.cleancommerce.application.usecases.auth;

import com.genka.cleancommerce.application.usecases.auth.dtos.UserSignUpInput;
import com.genka.cleancommerce.domain.user.dtos.UserDTO;

public interface UserSignUp {
    UserDTO execute(UserSignUpInput userSignUpInput);
}


