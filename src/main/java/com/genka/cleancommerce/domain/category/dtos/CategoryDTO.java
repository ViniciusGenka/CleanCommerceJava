package com.genka.cleancommerce.domain.category.dtos;

import java.util.UUID;

public record CategoryDTO(
        UUID id,
        String name
) {
}
