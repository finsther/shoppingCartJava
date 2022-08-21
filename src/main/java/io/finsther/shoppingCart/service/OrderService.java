package io.finsther.shoppingCart.service;

import io.finsther.shoppingCart.model.Cart;
import io.finsther.shoppingCart.model.Order;
import io.finsther.shoppingCart.model.Product;
import io.finsther.shoppingCart.repository.OrderRepository;
import io.finsther.shoppingCart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order getOrderDetail(Long orderId) {
        Optional<Order> order = this.orderRepository.findById(orderId);
        return order.orElse(null);
    }

    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    public Boolean checkProductAvailability(List<Cart> products) {
        /* check if product stock is available */
        for (Cart cart : products) {
            Long productId = cart.getProductId();
            Optional<Product> optProduct = productRepository.findById(productId);
            /* if product doesnt exist */
            if (!optProduct.isPresent()) {
                return false;
            }

            Product product = optProduct.get();

            if (product.getQuantity() == 0 || product.getQuantity() < cart.getQuantity()) {
                return false;
            }
        }
        return true;
    }

    public Double getOrderAmount(List<Cart> products) {
        double amount;
        double totalAmount = 0d;
        int available = 0;

        for (Cart cart : products) {

            Long productId = cart.getProductId();
            Optional<Product> optProduct = productRepository.findById(productId);

            if (!optProduct.isPresent()) {
                continue;
            }

            Product product = optProduct.get();

            if (product.getQuantity() < cart.getQuantity()) {
                amount = product.getPrice() * product.getQuantity();
                cart.setQuantity(product.getQuantity());
            } else {
                amount = cart.getQuantity() * product.getPrice();
                available = product.getQuantity() - cart.getQuantity();
            }

            totalAmount += amount;
            product.setQuantity(available);
            available = 0;

            cart.setAmount(amount);
            productRepository.save(product);
        }

        return totalAmount;
    }
}
