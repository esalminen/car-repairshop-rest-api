package com.car_repairshop.rest_api.model;

/**
 * This class represents a customers car.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 23.2.2023
 * 
 *        Car class contains all the information of a car license
 *        plate, brand, model, color, year and mileage.
 */

public class Car {

  private String licensePlate;
  private String brand;
  private String model;
  private String color;
  private String year;
  private int mileage;

  public String getLicensePlate() {
    return this.licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getYear() {
    return this.year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public int getMileage() {
    return this.mileage;
  }

  public void setMileage(int mileage) {
    this.mileage = mileage;
  }

  public Car() {
  }
}
