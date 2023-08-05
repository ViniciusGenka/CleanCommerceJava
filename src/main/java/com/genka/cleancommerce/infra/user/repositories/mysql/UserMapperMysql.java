package com.genka.cleancommerce.infra.user.repositories.mysql;

import com.genka.cleancommerce.domain.address.Address;
import com.genka.cleancommerce.domain.user.User;
import com.genka.cleancommerce.infra.address.repositories.mysql.AddressSchemaMysql;

public class UserMapperMysql {
    public static UserSchemaMysql entityToSchema(User userEntity) {
        return new UserSchemaMysql(
                null,
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getRole(),
                userEntity.getUsername()
        );
    }

    public static User schemaToEntity(UserSchemaMysql userSchema) {
        return new User(
                userSchema.getId(),
                userSchema.getEmail(),
                userSchema.getPassword(),
                userSchema.getRole(),
                userSchema.getUsername()
        );
    }
}
