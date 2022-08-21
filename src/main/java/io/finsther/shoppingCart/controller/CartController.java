package io.finsther.shoppingCart.controller;

import io.finsther.shoppingCart.dto.OrderDTO;
import io.finsther.shoppingCart.dto.ResponseOrderDTO;
import io.finsther.shoppingCart.model.Customer;
import io.finsther.shoppingCart.model.Order;
import io.finsther.shoppingCart.model.Product;
import io.finsther.shoppingCart.service.CustomerService;
import io.finsther.shoppingCart.service.OrderService;
import io.finsther.shoppingCart.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {
    private Logger logger = LoggerFactory.getLogger(CartController.class);

    private OrderService orderService;
    private ProductService productService;
    private CustomerService customerService;

    public CartController(OrderService orderService, ProductService productService, CustomerService customerService) {
        this.orderService = orderService;
        this.productService = productService;
        this.customerService = customerService;
    }

    @GetMapping(value = "/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable Long orderId) {

        Order order = orderService.getOrderDetail(orderId);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/makeNewOrder")
    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        Double amount = orderService.getOrderAmount(orderDTO.getProducts());

        Customer customer =
                new Customer(
                        orderDTO.getCustomerName(),
                        orderDTO.getCustomerEmail(),
                        orderDTO.getCustomerAddress(),
                        orderDTO.getCustomerPhone());
        Long customerId = customerService.isCustomerPresent(customer);
        /* register new customer if not exist in database */
        if (customerId != null) {
            customer.setId(customerId);
            logger.info("Customer found in database: " + customerId);
        } else {
            customer = customerService.saveCustomer(customer);
            logger.info("New customer registered with id : " + customer.getId());
        }

        if(!orderService.checkProductAvailability(orderDTO.getProducts())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseOrderDTO);
        }

        Integer orderNumber = (int) (Math.random() * (9000 - 1000 + 1) + 1000);
        Date orderDate = new Date(System.currentTimeMillis());
        Order order = new Order(orderNumber, customer, orderDate, orderDTO.getProducts());
        order = orderService.placeOrder(order);
        logger.info("Your order has been placed successfully!");

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setNumber(orderNumber);
        responseOrderDTO.setCreationDate(order.getCreationDate());
        responseOrderDTO.setOrderId(order.getId());

        return ResponseEntity.ok(responseOrderDTO);
    }
}
