package com.genka.cleancommerce.infra.address.repositories.mysql;

import com.genka.cleancommerce.application.address.gateways.AddressDatabaseGateway;
import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.address.dtos.AddressDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Component
public class AddressDatabaseGatewayMysql implements AddressDatabaseGateway {
    private final AddressRepositoryMysql addressRepository;

    public AddressDatabaseGatewayMysql(AddressRepositoryMysql addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        AddressSchemaMysql addressSchema = AddressMapperMysql.entityToSchema(address);
        AddressSchemaMysql savedAddressSchema = this.addressRepository.save(addressSchema);
        return AddressMapperMysql.schemaToEntity(savedAddressSchema);
    }

    @Override
    public Optional<Address> findById(UUID id) {
        Optional<AddressSchemaMysql> addressSchema = this.addressRepository.findById(id);
        return addressSchema.map(AddressMapperMysql::schemaToEntity);
    }

    @Override
    public Optional<Address> findByIdAndUserId(UUID id, UUID userId) {
        Optional<AddressSchemaMysql> addressSchema = this.addressRepository.findByIdAndUserId(id, userId);
        return addressSchema.map(AddressMapperMysql::schemaToEntity);
    }

    @Override
    public List<Address> findByUserId(UUID id) {
        List<AddressSchemaMysql> addressSchemas = this.addressRepository.findByUserId(id);
        return addressSchemas.stream().map(AddressMapperMysql::schemaToEntity).toList();
    }
}
