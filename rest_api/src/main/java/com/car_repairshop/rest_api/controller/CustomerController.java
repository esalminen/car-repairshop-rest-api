package com.car_repairshop.rest_api.controller;

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

import com.car_repairshop.rest_api.model.Car;
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
      return new ResponseEntity<Customer>(result, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Adds a new car to the customer. Returns the added car.
   * 
   * @param car
   * @param customerId
   * @return ResponseEntity<Car>
   */
  @PostMapping("/customers/{customerId}/cars")
  public ResponseEntity<Car> addCarToCustomer(@RequestBody Car car, @PathVariable Long customerId) {
    Car result = cs.addCarToCustomer(car, customerId);
    if (result != null) {
      return new ResponseEntity<Car>(result, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Car>(result, HttpStatus.BAD_REQUEST);
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
   * @param customerId
   * @return ResponseEntity<Customer>
   */
  @GetMapping("/customers/{customerId}")
  public ResponseEntity<Customer> getCustomerByCustomerNumber(@PathVariable Long customerId) {
    Customer result = cs.getCustomerById(customerId);
    if (result != null) {
      return new ResponseEntity<Customer>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Get all cars of a customer by customer id.
   * 
   * @param customerId
   * @return ResponseEntity<Customer>
   */
  @GetMapping("/customers/{customerId}/cars")
  public ResponseEntity<List<Car>> getCarsByCustomerId(@PathVariable Long customerId) {
    List<Car> result = cs.getCarsOfCustomer(customerId);
    if (result != null) {
      return new ResponseEntity<List<Car>>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<List<Car>>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Get a car of a customer by customer id and license plate.
   * 
   * @param customerId
   * @param licensePlate
   * @return ResponseEntity<Car>
   */
  @GetMapping("/customers/{customerId}/cars/{licensePlate}")
  public ResponseEntity<Car> getCarByLicensePlate(@PathVariable Long customerId, @PathVariable String licensePlate) {
    Car result = cs.getCarOfCustomerByLicensePlate(customerId, licensePlate);
    if (result != null) {
      return new ResponseEntity<Car>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Car>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Updates a customer by id and returns the updated customer.
   * 
   * @param customerId
   * @param customer
   * @return ResponseEntity<Customer>
   */
  @PutMapping("/customers/{customerId}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
    Customer result = cs.updateCustomer(customerId, customer);
    if (result != null) {
      return new ResponseEntity<Customer>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Updates a car by id and returns the updated car.
   * 
   * @param customerId
   * @param licensePlate
   * @param car
   * @return ResponseEntity<Car>
   */
  @PutMapping("/customers/{customerId}/cars/{licensePlate}")
  public ResponseEntity<Car> updateCar(@PathVariable Long customerId, @PathVariable String licensePlate,
      @RequestBody Car car) {
    Car result = cs.updateCar(customerId, car);
    if (result != null) {
      return new ResponseEntity<Car>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Car>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Deletes a customer by id and returns the deleted customer.
   * 
   * @param customerId
   * @return ResponseEntity<Customer>
   */
  @DeleteMapping("/customers/{customerId}")
  public ResponseEntity<Customer> deleteCustomer(@PathVariable Long customerId) {
    Customer result = cs.deleteCustomer(customerId);
    if (result != null) {
      return new ResponseEntity<Customer>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Customer>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Deletes a car by id and returns the deleted car.
   * 
   * @param customerId
   * @param licensePlate
   * @return ResponseEntity<Car>
   */
  @DeleteMapping("/customers/{customerId}/cars/{licensePlate}")
  public ResponseEntity<Car> deleteCar(@PathVariable Long customerId, @PathVariable String licensePlate) {
    Car result = cs.deleteCar(customerId, licensePlate);
    if (result != null) {
      return new ResponseEntity<Car>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Car>(result, HttpStatus.NOT_FOUND);
    }
  }

}
