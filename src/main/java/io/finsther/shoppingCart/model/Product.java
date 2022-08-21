package io.finsther.shoppingCart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "products")
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(length = 80)
    @Getter
    @Setter
    private String name;

    @Column(length = 180)
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Double price;

    public Product() {
    }

    public Product(Long id, String name, String description, Integer quantity, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }
}
