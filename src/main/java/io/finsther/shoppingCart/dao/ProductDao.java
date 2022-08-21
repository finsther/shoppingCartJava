package io.finsther.shoppingCart.dao;

import io.finsther.shoppingCart.model.Product;

import java.util.List;

public interface ProductDao {

    Product findBy(Long id);

    List<Product> getAll();

    void register(Product product);
}
