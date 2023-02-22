package com.car_repairshop.rest_api;

import javax.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @PostConstruct
  public void init() {
    Customer customer = new Customer();
    customer.setFirstName("John");
    customer.setLastName("Doe");
    customer.setEmail("john.doe@gmail.com");
    customer.setPhone("040-5565885");
    customer.setAddress("Street 1, 12345 City");

    Customer customer2 = new Customer();
    customer2.setFirstName("Jane");
    customer2.setLastName("Doe");
    customer2.setEmail("jane.doe@gmail.com");
    customer2.setPhone("040-5565885");
    customer2.setAddress("Street 1, 12345 City");

    customerRepository.save(customer);
    customerRepository.save(customer2);

  }

  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }
}
