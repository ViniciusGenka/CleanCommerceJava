package com.genka.cleancommerce.domain.address.enums;

public enum AddressStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private final String name;

    private AddressStatus(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
