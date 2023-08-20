package com.genka.cleancommerce.application.services.auth;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    String generateAccessToken(UserDetails userAuthDetails);

    String validateToken(String token);
}
