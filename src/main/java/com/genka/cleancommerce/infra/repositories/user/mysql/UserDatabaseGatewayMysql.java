package com.genka.cleancommerce.infra.repositories.user.mysql;

import com.genka.cleancommerce.application.gateways.UserDatabaseGateway;
import com.genka.cleancommerce.domain.user.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Primary
@Component
public class UserDatabaseGatewayMysql implements UserDatabaseGateway {
    private final UserRepositoryMysql userRepository;

    public UserDatabaseGatewayMysql(UserRepositoryMysql userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        UserSchemaMysql userSchema = UserMapperMysql.entityToSchema(user);
        System.out.println(userSchema);
        UserSchemaMysql savedUser = this.userRepository.save(userSchema);
        return UserMapperMysql.schemaToEntity(savedUser);
    }

    @Override
    public Optional<User> findById(UUID id) {
        Optional<UserSchemaMysql> userSchema = this.userRepository.findById(id);
        return userSchema.map(UserMapperMysql::schemaToEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserSchemaMysql> userSchema = this.userRepository.findByEmail(email);
        return userSchema.map(UserMapperMysql::schemaToEntity);
    }
}
