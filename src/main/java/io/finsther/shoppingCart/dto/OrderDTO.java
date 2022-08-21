package io.finsther.shoppingCart.dto;

import io.finsther.shoppingCart.model.Cart;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
public class OrderDTO {

    @Getter
    @Setter
    private List<Cart> products;

    @Getter
    @Setter
    private String customerEmail;

    @Getter
    @Setter
    private String customerName;

    @Getter
    @Setter
    private String customerAddress;

    @Getter
    @Setter
    private String customerPhone;

    public OrderDTO() {
    }

    public OrderDTO(List<Cart> products, String customerEmail, String customerName, String customerAddress, String customerPhone) {
        this.products = products;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }
}
