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
   * Add a new customer to the list. Returns the added customer with the new id.
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
   * Add a new car to the customer. Returns the added car.
   */
  public Car addCarToCustomer(Car car, Long customerId) {
    Customer customer = getCustomerById(customerId);
    if (customer != null) {
      customer.addCar(car);
      return car;
    } else {
      return null;
    }
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
  public Customer getCustomerById(Long customerId) {
    for (Customer customer : customers) {
      if (customer.getId() == customerId) {
        return customer;
      }
    }
    return null;
  }

  /**
   * Returns a list of cars of a customer.
   */
  public List<Car> getCarsOfCustomer(Long customerId) {
    Customer customer = getCustomerById(customerId);
    if (customer != null) {
      return customer.getCars();
    } else {
      return null;
    }
  }

  /**
   * Returns a car of a customer.
   */
  public Car getCarOfCustomerByLicensePlate(Long customerId, String licensePlate) {
    Customer customer = getCustomerById(customerId);
    if (customer != null) {
      for (Car car : customer.getCars()) {
        if (car.getLicensePlate().equals(licensePlate)) {
          return car;
        }
      }
    }
    return null;
  }

  /**
   * Updates customer data. Returns the updated customer.
   */
  public Customer updateCustomer(Long customerId, Customer updatedCustomer) {
    Customer customer = getCustomerById(customerId);
    if (customer != null) {
      customer.setFirstName(updatedCustomer.getFirstName());
      customer.setLastName(updatedCustomer.getLastName());
      customer.setEmail(updatedCustomer.getEmail());
      customer.setPhone(updatedCustomer.getPhone());
      customer.setAddress(updatedCustomer.getAddress());
      return customer;
    } else {
      return null;
    }
  }

  /**
   * Updates car data. Returns the updated car.
   */
  public Car updateCar(Long customerId, Car updatedCar) {
    Customer customer = getCustomerById(customerId);
    Car car = null;
    if (customer != null) {
      for (Car c : customer.getCars()) {
        if (c.getLicensePlate().equals(updatedCar.getLicensePlate())) {
          c = updatedCar;
          car = c;
        }
      }
      if (car != null) {
        return car;
      }
    }
    return null;
  }

  /**
   * Deletes a customer by id. Returns true if the customer was deleted.
   */
  public Customer deleteCustomer(Long customerId) {
    Customer customer = getCustomerById(customerId);
    if (customer != null) {
      customers.remove(customer);
      return customer;
    } else {
      return null;
    }
  }

  /**
   * Deletes a car by license plate. Returns deleted car.
   */
  public Car deleteCar(Long customerId, String licensePlate) {
    Customer customer = getCustomerById(customerId);
    Car car = null;
    if (customer != null) {
      for (Car c : customer.getCars()) {
        if (c.getLicensePlate().equals(licensePlate)) {
          car = c;
        }
      }
      if (car != null) {
        customer.getCars().remove(car);
        return car;
      }
    }
    return null;
  }
}
