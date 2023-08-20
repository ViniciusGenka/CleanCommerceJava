package com.genka.cleancommerce.infra.repositories.address.mysql;

import com.genka.cleancommerce.domain.address.Address;

public class AddressMapperMysql {
    public static AddressSchemaMysql entityToSchema(Address addressEntity) {
        return new AddressSchemaMysql(
                null,
                addressEntity.getUserId(),
                addressEntity.getCity(),
                addressEntity.getComplement(),
                addressEntity.getContactFullName(),
                addressEntity.getContactPhoneNumber(),
                addressEntity.getNeighborhood(),
                addressEntity.getPostalCode(),
                addressEntity.getState(),
                addressEntity.getStatus(),
                addressEntity.getStreet(),
                addressEntity.getStreetNumber(),
                addressEntity.getType()
        );
    }

    public static Address schemaToEntity(AddressSchemaMysql addressSchema) {
        return new Address(
                null,
                addressSchema.getUserId(),
                addressSchema.getCity(),
                addressSchema.getComplement(),
                addressSchema.getContactFullName(),
                addressSchema.getContactPhoneNumber(),
                addressSchema.getNeighborhood(),
                addressSchema.getPostalCode(),
                addressSchema.getState(),
                addressSchema.getStatus(),
                addressSchema.getStreet(),
                addressSchema.getStreetNumber(),
                addressSchema.getType()
        );
    }
}
