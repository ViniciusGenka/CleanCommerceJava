package com.genka.cleancommerce.application.auth.usecases;

import com.genka.cleancommerce.application.auth.dtos.UserSignInInput;

public interface UserSignIn {
    public String execute(UserSignInInput userSignInInput);
}
