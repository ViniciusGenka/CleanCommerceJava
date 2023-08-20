package com.genka.cleancommerce.infra.services.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.genka.cleancommerce.application.services.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Value("${access.token.secret}")
    private String secret;

    @Override
    public String generateAccessToken(UserDetails userAuthDetails) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            return JWT.create()
                    .withIssuer("cleancommerce")
                    .withSubject(userAuthDetails.getUsername())
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Access token generation failed", ex);
        }
    }

    @Override
    public String validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(this.secret);
        return JWT.require(algorithm)
                .withIssuer("cleancommerce")
                .build()
                .verify(token)
                .getSubject();
    }
}
