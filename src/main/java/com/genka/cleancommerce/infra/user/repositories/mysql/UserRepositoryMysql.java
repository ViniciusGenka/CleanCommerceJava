package com.genka.cleancommerce.infra.user.repositories.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepositoryMysql extends JpaRepository<UserSchemaMysql, UUID> {
    Optional<UserSchemaMysql> findByEmail(String email);
}
