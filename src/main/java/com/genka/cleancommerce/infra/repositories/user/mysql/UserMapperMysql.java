package com.genka.cleancommerce.infra.repositories.user.mysql;

import com.genka.cleancommerce.domain.user.User;

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
