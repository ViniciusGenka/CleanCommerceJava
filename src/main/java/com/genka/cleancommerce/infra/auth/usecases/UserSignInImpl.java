package com.genka.cleancommerce.infra.auth.usecases;

import com.genka.cleancommerce.application.auth.usecases.UserSignIn;
import com.genka.cleancommerce.application.auth.dtos.UserSignInInput;
import com.genka.cleancommerce.infra.auth.adapters.UserAuthDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserSignInImpl implements UserSignIn {
    private final AuthenticationManager authenticationManager;

    public UserSignInImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public String execute(UserSignInInput userSignInInput) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userSignInInput.email(), userSignInInput.password());
        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserAuthDetails user = (UserAuthDetails) authentication.getPrincipal();
    }
}
