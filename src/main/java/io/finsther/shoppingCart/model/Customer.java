package io.finsther.shoppingCart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(length = 80)
    @Getter
    @Setter
    private String name;

    @Column(length = 255)
    @Getter
    @Setter
    private String email;

    @Column(length = 160)
    @Getter
    @Setter
    private String address;

    @Column(length = 10)
    @Getter
    @Setter
    private String phone;

    public Customer() {
    }

    public Customer(String name, String email, String address, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }
}
