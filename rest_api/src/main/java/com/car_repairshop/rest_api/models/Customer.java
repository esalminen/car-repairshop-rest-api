package com.car_repairshop.rest_api.models;

/**
 * This class represents a customer.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 23.2.2023
 * 
 * @see Person
 *      Besides of Person properties, Customer has a unique customer number.
 */

public class Customer extends Person {
  private String customerNumber;

  public String getCustomerNumber() {
    return this.customerNumber;
  }

  public void setCustomerNumber(String customerNumber) {
    this.customerNumber = customerNumber;
  }

  public Customer() {
  }

  public Customer(String firstName, String lastName, String email, String phone, String address,
      String customerNumber) {
    super(firstName, lastName, email, phone, address);
    this.customerNumber = customerNumber;
  }
}
