package com.genka.cleancommerce.infra.repositories.user.mongodb;

import com.genka.cleancommerce.application.gateways.UserDatabaseGateway;
import com.genka.cleancommerce.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserDatabaseGatewayMongodb implements UserDatabaseGateway {
    private final UserRepositoryMongodb userRepository;

    public UserDatabaseGatewayMongodb(UserRepositoryMongodb userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        UserSchemaMongodb userSchema = new UserSchemaMongodb(
                null,
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getUsername()
        );
        UserSchemaMongodb savedUser = this.userRepository.save(userSchema);
        return new User(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getPassword(),
                savedUser.getRole(),
                savedUser.getUsername()
        );
    }

    @Override
    public Optional<User> findById(UUID id) {
        Optional<UserSchemaMongodb> userSchema = this.userRepository.findById(id);
        return userSchema.map((schema) -> new User(
                schema.getId(),
                schema.getEmail(),
                schema.getPassword(),
                schema.getRole(),
                schema.getUsername()
        ));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserSchemaMongodb> userSchema = this.userRepository.findByEmail(email);
        return userSchema.map((schema) -> new User(
                schema.getId(),
                schema.getEmail(),
                schema.getPassword(),
                schema.getRole(),
                schema.getUsername()
        ));
    }
}
