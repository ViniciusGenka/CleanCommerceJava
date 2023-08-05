package com.genka.cleancommerce.domain.address;

import com.genka.cleancommerce.domain.address.enums.AddressStatus;
import com.genka.cleancommerce.domain.address.enums.AddressType;

import java.util.Objects;
import java.util.UUID;

public class Address {
    private UUID id;
    private UUID userId;
    private String city;
    private String complement;
    private String contactFullName;
    private String contactPhoneNumber;
    private String neighborhood;
    private String postalCode;
    private String state;
    private AddressStatus status;
    private String street;
    private Integer streetNumber;
    private AddressType type;

    public Address() {
    }

    public Address(UUID userId, String city, String complement, String contactFullName, String contactPhoneNumber, String neighborhood, String postalCode, String state, AddressStatus status, String street, Integer streetNumber, AddressType type) {
        this.userId = userId;
        this.city = city;
        this.complement = complement;
        this.contactFullName = contactFullName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.neighborhood = neighborhood;
        this.postalCode = postalCode;
        this.state = state;
        this.status = status;
        this.street = street;
        this.streetNumber = streetNumber;
        this.type = type;
    }

    public Address(UUID id, UUID userId, String city, String complement, String contactFullName, String contactPhoneNumber, String neighborhood, String postalCode, String state, AddressStatus status, String street, Integer streetNumber, AddressType type) {
        this.id = id;
        this.userId = userId;
        this.city = city;
        this.complement = complement;
        this.contactFullName = contactFullName;
        this.contactPhoneNumber = contactPhoneNumber;
        this.neighborhood = neighborhood;
        this.postalCode = postalCode;
        this.state = state;
        this.status = status;
        this.street = street;
        this.streetNumber = streetNumber;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getContactFullName() {
        return contactFullName;
    }

    public void setContactFullName(String contactFullName) {
        this.contactFullName = contactFullName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public AddressStatus getStatus() {
        return status;
    }

    public void setStatus(AddressStatus status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public AddressType getType() {
        return type;
    }

    public void setType(AddressType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(userId, address.userId) && Objects.equals(city, address.city) && Objects.equals(complement, address.complement) && Objects.equals(contactFullName, address.contactFullName) && Objects.equals(contactPhoneNumber, address.contactPhoneNumber) && Objects.equals(neighborhood, address.neighborhood) && Objects.equals(postalCode, address.postalCode) && Objects.equals(state, address.state) && status == address.status && Objects.equals(street, address.street) && Objects.equals(streetNumber, address.streetNumber) && type == address.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, city, complement, contactFullName, contactPhoneNumber, neighborhood, postalCode, state, status, street, streetNumber, type);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", city='" + city + '\'' +
                ", complement='" + complement + '\'' +
                ", contactFullName='" + contactFullName + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", status=" + status +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", type=" + type +
                '}';
    }
}
