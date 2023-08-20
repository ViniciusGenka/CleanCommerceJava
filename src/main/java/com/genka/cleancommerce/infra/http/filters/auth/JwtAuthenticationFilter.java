package com.genka.cleancommerce.infra.http.filters.auth;

import com.genka.cleancommerce.application.exceptions.EntityNotFoundException;
import com.genka.cleancommerce.application.gateways.UserDatabaseGateway;
import com.genka.cleancommerce.domain.user.User;
import com.genka.cleancommerce.infra.adapters.UserAuthDetails;
import com.genka.cleancommerce.infra.services.auth.AuthenticationServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final AuthenticationServiceImpl authenticationService;
    private final UserDatabaseGateway userDatabaseGateway;

    public JwtAuthenticationFilter(AuthenticationServiceImpl authenticationService, UserDatabaseGateway userDatabaseGateway) {
        this.authenticationService = authenticationService;
        this.userDatabaseGateway = userDatabaseGateway;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String accessToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        accessToken = authHeader.substring(7);
        userEmail = this.authenticationService.validateToken(accessToken);
        User user = this.userDatabaseGateway.findByEmail(userEmail).orElseThrow(() -> new EntityNotFoundException("User from access token payload not found"));
        UserAuthDetails userAuthDetails = new UserAuthDetails(user);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userAuthDetails, null, userAuthDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
