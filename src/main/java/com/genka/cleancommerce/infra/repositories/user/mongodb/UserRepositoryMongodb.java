package com.genka.cleancommerce.infra.repositories.user.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepositoryMongodb extends MongoRepository<UserSchemaMongodb, UUID> {
    Optional<UserSchemaMongodb> findByEmail(String email);
}
