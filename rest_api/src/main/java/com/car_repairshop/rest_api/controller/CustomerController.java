package com.car_repairshop.rest_api.controller;

import javax.annotation.PostConstruct;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.car_repairshop.rest_api.model.Customer;
import com.car_repairshop.rest_api.service.CustomerService;

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

  @PostConstruct
  public void init() {

  }

  @PostMapping("/customers")
  public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
    Customer result = cs.addCustomer(customer);
    if (result != null) {
      return new ResponseEntity<Customer>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/customers")
  public ResponseEntity<List<Customer>> getCustomers() {
    if (!cs.getCustomers().isEmpty()) {
      return new ResponseEntity<List<Customer>>(cs.getCustomers(), HttpStatus.OK);
    }
    return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/customers/{id}")
  public ResponseEntity<Customer> getCustomerByCustomerNumber(@PathVariable int id) {
    Customer result = cs.getCustomerById(id);
    if (result != null) {
      return new ResponseEntity<Customer>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.NOT_FOUND);
    }
  }

}
