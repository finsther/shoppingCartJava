package io.finsther.shoppingCart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "carts")
@ToString
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Long productId;

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Double amount;

    @JsonIgnore
    @ManyToOne
    @Getter
    @Setter
    private Order order;

    public Cart() {
    }

    public Cart(Long productId, Integer quantity, Double amount) {
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Cart(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
