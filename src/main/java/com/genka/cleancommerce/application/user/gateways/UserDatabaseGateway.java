package com.genka.cleancommerce.application.user.gateways;

import com.genka.cleancommerce.domain.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserDatabaseGateway {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
}
