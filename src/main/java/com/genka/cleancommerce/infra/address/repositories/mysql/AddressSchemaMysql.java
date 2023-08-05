package com.genka.cleancommerce.infra.address.repositories.mysql;

import com.genka.cleancommerce.domain.address.enums.AddressStatus;
import com.genka.cleancommerce.domain.address.enums.AddressType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "addresses")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AddressSchemaMysql {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
}
