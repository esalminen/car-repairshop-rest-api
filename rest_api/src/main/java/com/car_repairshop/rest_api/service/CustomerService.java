package com.car_repairshop.rest_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.car_repairshop.rest_api.model.*;

/**
 * This class represents a serviceclass for all customers.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 23.2.2023
 * 
 *        Class handles all the logic of handling the customer classes.
 */

@Service
public class CustomerService {
  private List<Customer> customers = new ArrayList<>();

  /**
   * Adds a new customer to the list. Returns the added customer with the new id.
   */
  public Customer addCustomer(Customer customer) {
    Long highestId = 0L;
    for (Customer c : customers) {
      if (c.getId() > highestId) {
        highestId = c.getId();
      }
    }
    customer.setId(highestId + 1);
    customers.add(customer);
    return customer;
  }

  /**
   * Returns a list of all customers.
   */
  public List<Customer> getCustomers() {
    return customers;
  }

  /**
   * Returns a customer by id.
   */
  public Customer getCustomerById(int customerNumber) {
    for (Customer customer : customers) {
      if (customer.getId() == customerNumber) {
        return customer;
      }
    }
    return null;
  }
}
