package com.genka.cleancommerce.domain.address.enums;

public enum AddressType {
    RESIDENTIAL("RESIDENTIAL"),
    WAREHOUSE("WAREHOUSE");

    private final String name;

    private AddressType(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
