package io.finsther.shoppingCart.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ResponseOrderDTO {

    @Getter
    @Setter
    private Double amount;

    @Getter
    @Setter
    private int number;

    @Getter
    @Setter
    private Date creationDate;

    @Getter
    @Setter
    private Long orderId;
}
