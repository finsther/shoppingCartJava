package io.finsther.shoppingCart.service;

import io.finsther.shoppingCart.model.Customer;
import io.finsther.shoppingCart.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Long isCustomerPresent(Customer customer) {
        Customer customerValue = customerRepository.getCustomerByEmail(customer.getEmail());
        return customerValue != null ? customerValue.getId() : null;
    }
}
