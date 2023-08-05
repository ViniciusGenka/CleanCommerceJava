package com.genka.cleancommerce.application.auth.usecases;

import com.genka.cleancommerce.application.auth.dtos.UserSignUpInput;
import com.genka.cleancommerce.domain.user.dtos.UserDTO;

public interface UserSignUp {
    public UserDTO execute(UserSignUpInput userSignUpInput);
}


