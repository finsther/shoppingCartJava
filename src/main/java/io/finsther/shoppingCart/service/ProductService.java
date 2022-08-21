package io.finsther.shoppingCart.service;

import io.finsther.shoppingCart.model.Product;
import io.finsther.shoppingCart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }
}
