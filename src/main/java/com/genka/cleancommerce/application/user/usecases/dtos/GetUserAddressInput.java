package com.genka.cleancommerce.application.user.usecases.dtos;

import java.util.UUID;

public record GetUserAddressInput(UUID addressId, UUID userId) {
}
