package com.car_repairshop.rest_api.controller;

import javax.annotation.PostConstruct;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car_repairshop.rest_api.model.Customer;
import com.car_repairshop.rest_api.service.CustomerService;

/**
 * This class represents a controller for all customers.
 */
@RestController
@RequestMapping("/api")
public class CustomerController {

  CustomerService cs;

  /**
   * Constructor for CustomerController with dependency injection.
   * 
   * @param customerService
   */
  @Autowired
  public CustomerController(CustomerService customerService) {
    cs = customerService;
  }

  /**
   * Adds a new customer to the list. Returns the added customer with the new id.
   * 
   * @param customer
   * @return ResponseEntity<Customer>
   */
  @PostMapping("/customers")
  public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
    Customer result = cs.addCustomer(customer);
    if (result != null) {
      return new ResponseEntity<Customer>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Returns a list of all customers.
   * 
   * @return ResponseEntity<List<Customer>>
   */
  @GetMapping("/customers")
  public ResponseEntity<List<Customer>> getCustomers() {
    if (!cs.getCustomers().isEmpty()) {
      return new ResponseEntity<List<Customer>>(cs.getCustomers(), HttpStatus.OK);
    }
    return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
  }

  /**
   * Returns a customer by id.
   * 
   * @param id
   * @return ResponseEntity<Customer>
   */
  @GetMapping("/customers/{id}")
  public ResponseEntity<Customer> getCustomerByCustomerNumber(@PathVariable int id) {
    Customer result = cs.getCustomerById(id);
    if (result != null) {
      return new ResponseEntity<Customer>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Updates a customer by id and returns the updated customer.
   * 
   * @param id
   * @param customer
   * @return ResponseEntity<Customer>
   */
  @PutMapping("/customers/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
    Customer result = cs.getCustomerById(id);
    if (result != null) {
      result.setFirstName(customer.getFirstName());
      result.setLastName(customer.getLastName());
      result.setPhone(customer.getPhone());
      result.setAddress(customer.getAddress());
      result.setEmail(customer.getEmail());
      return new ResponseEntity<Customer>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Deletes a customer by id and returns the deleted customer.
   * 
   * @param id
   * @return ResponseEntity<Customer>
   */
  @DeleteMapping("/customers/{id}")
  public ResponseEntity<Customer> deleteCustomer(@PathVariable int id) {
    Customer result = cs.getCustomerById(id);
    if (result != null) {
      cs.getCustomers().remove(result);
      return new ResponseEntity<Customer>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.NOT_FOUND);
    }
  }

}
