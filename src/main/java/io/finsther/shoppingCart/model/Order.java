package io.finsther.shoppingCart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Integer number;

    @Column(name = "creation_date")
    @Getter
    @Setter
    private Date creationDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Cart.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @Getter
    @Setter
    private List<Cart> cartItems;

    public Order() {
    }

    public Order(Integer number, Customer customer, Date creationDate, List<Cart> cartItems) {
        this.number = number;
        this.customer = customer;
        this.creationDate = creationDate;
        this.cartItems = cartItems;
    }
}
