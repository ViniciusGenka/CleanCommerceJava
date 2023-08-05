package com.genka.cleancommerce.domain.user.dtos;

import com.genka.cleancommerce.domain.user.User;

import java.util.UUID;

public record UserDTO(UUID id, String username, String email) {
    public UserDTO(User user) {
        this(user.getId(), user.getUsername(), user.getEmail());
    }
}
