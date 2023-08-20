package com.genka.cleancommerce.infra.services.auth;

import com.genka.cleancommerce.application.exceptions.EntityNotFoundException;
import com.genka.cleancommerce.application.gateways.UserDatabaseGateway;
import com.genka.cleancommerce.domain.user.User;
import com.genka.cleancommerce.infra.adapters.UserAuthDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDatabaseGateway userDatabaseGateway;

    public UserDetailsServiceImpl(UserDatabaseGateway userDatabaseGateway) {
        this.userDatabaseGateway = userDatabaseGateway;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws EntityNotFoundException {
        User user = this.userDatabaseGateway.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Incorrect email"));
        return new UserAuthDetails(user);
    }
}
