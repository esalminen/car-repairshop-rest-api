package com.car_repairshop.rest_api.controllers;

import javax.annotation.PostConstruct;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car_repairshop.rest_api.models.Customer;

@RestController
public class CustomerController {

  @PostConstruct
  public void init() {

  }

  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return null;
  }
}
