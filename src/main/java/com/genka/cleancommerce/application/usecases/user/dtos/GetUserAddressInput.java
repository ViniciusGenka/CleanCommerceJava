package com.genka.cleancommerce.application.usecases.user.dtos;

import java.util.UUID;

public record GetUserAddressInput(UUID addressId, UUID userId) {
}
