package com.anand.service;

import com.anand.dao.CustomerDAO;
import com.anand.exception.CustomerNotFoundException;
import com.anand.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {
//        customer.setId(customerIdCount);
//        customers.add(customer);
//        customerIdCount++;
//        return customer;
        return customerDAO.save(customer);
    }

    public List<Customer> getCustomers () {
        return customerDAO.findAll();
    }

    public Customer getCustomer (int customerId) {
        Optional<Customer> customerOptional = customerDAO.findById(customerId);
        if (!customerOptional.isPresent()) {
            throw new CustomerNotFoundException("Customer is not available");
        }

        return customerOptional.get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
//        customers
//                .stream()
//                .forEach(c -> {
//                    if (c.getId() == customerId) {
//                        c.setFirstName(customer.getFirstName());
//                        c.setLastName(customer.getLastName());
//                        c.setEmail(customer.getEmail());
//                    }
//                });
        customer.setId(customerId);
        return customerDAO.save(customer);
//        return customers
//                .stream()
//                .filter(c -> c.getId() == customerId)
//                .findFirst()
//                .get();
    }

    public void deleteCustomer(int  customerId) {
//        customers
//                .stream()
//                .forEach(customer -> {
//                    if (customer.getId() == customerId) {
//                        customers.remove(customer);
//                    }
//                });
        customerDAO.deleteById(customerId);
    }
}
