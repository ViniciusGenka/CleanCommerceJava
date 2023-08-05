package com.genka.cleancommerce.domain.user.enums;

public enum Role {
    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN");

    private final String name;

    private Role(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
