package com.genka.cleancommerce.infra.usecases.auth;

import com.genka.cleancommerce.application.usecases.auth.UserSignIn;
import com.genka.cleancommerce.application.usecases.auth.dtos.UserSignInInput;
import com.genka.cleancommerce.infra.adapters.UserAuthDetails;
import com.genka.cleancommerce.infra.services.auth.AuthenticationServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserSignInImpl implements UserSignIn {
    private final AuthenticationManager authenticationManager;
    private final AuthenticationServiceImpl authenticationService;

    public UserSignInImpl(AuthenticationManager authenticationManager, AuthenticationServiceImpl authenticationService) {
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
    }

    @Override
    public String execute(UserSignInInput userSignInInput) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userSignInInput.email(), userSignInInput.password());
        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserAuthDetails userAuthDetails = (UserAuthDetails) authentication.getPrincipal();
        return this.authenticationService.generateAccessToken(userAuthDetails);
    }
}
