package com.car_repairshop.rest_api.model;

/**
 * This class represents a person. It is an abstract class and cannot be
 * instantiated.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 23.2.2023
 * 
 * 
 *        Person class is a superclass for all people in the system. It contains
 *        all the basic information of a person.
 */

public abstract class Person {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String address;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Person() {
  }

  public Person(String firstName, String lastName, String email, String phone, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
    this.address = address;
  }
}
