package com.genka.cleancommerce.infra.address.repositories.mysql;

import com.genka.cleancommerce.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressRepositoryMysql extends JpaRepository<AddressSchemaMysql, UUID> {
    List<AddressSchemaMysql> findByUserId(UUID id);

    Optional<AddressSchemaMysql> findByIdAndUserId(UUID id, UUID userId);
}
