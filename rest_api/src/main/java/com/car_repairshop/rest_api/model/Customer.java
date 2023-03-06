package com.car_repairshop.rest_api.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a customer.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 23.2.2023
 * 
 * @see Person
 *      Besides of Person properties, Customer has a list of cars.
 */

public class Customer extends Person {
  private List<Car> cars = new ArrayList<>();

  public List<Car> getCars() {
    return this.cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  public void addCar(Car car) {
    this.cars.add(car);
  }

  public void removeCar(Car car) {
    this.cars.remove(car);
  }

  public Customer() {
  }
}
