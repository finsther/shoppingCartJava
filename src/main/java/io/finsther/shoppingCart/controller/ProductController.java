package io.finsther.shoppingCart.controller;

import io.finsther.shoppingCart.dao.ProductDao;
import io.finsther.shoppingCart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productDao.findBy(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void registerProduct(@RequestBody Product product) {
        productDao.register(product);
    }
}
