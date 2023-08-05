package com.genka.cleancommerce.domain.product.dtos;

import java.util.UUID;

public record ProductCategoryDTO(
        UUID id,
        String name
) {
}
