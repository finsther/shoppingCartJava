package io.finsther.shoppingCart.repository;

import io.finsther.shoppingCart.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer getCustomerByEmail(String email);
}
