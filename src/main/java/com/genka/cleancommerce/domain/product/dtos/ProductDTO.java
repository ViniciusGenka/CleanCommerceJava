package com.genka.cleancommerce.domain.product.dtos;

import com.genka.cleancommerce.domain.address.dtos.AddressDTO;

import java.util.UUID;

public record ProductDTO(
        UUID id,
        String description,
        Double price,
        AddressDTO stockAddress,
        Integer stockQuantity,
        String title
) {
}
