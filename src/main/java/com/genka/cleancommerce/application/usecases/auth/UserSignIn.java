package com.genka.cleancommerce.application.usecases.auth;

import com.genka.cleancommerce.application.usecases.auth.dtos.UserSignInInput;

public interface UserSignIn {
    String execute(UserSignInInput userSignInInput);
}
