package com.hasandag.entitiy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_address")
public class Address implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500, name="address")
    private String address;

    @Enumerated
    private AddressType addressType;
    private Boolean isActive;

    enum AddressType {
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }

}
