package com.car_repairshop.rest_api.model;

import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

/**
 * This class represents a repairshop worker.
 * 
 * @author Esa Salminen
 * @version 1.1
 * @since 11.3.2023
 * 
 * @see Person
 *      Besides of Person properties, Worker has a hourly wage and charge per
 *      hour which makes up the customer bill for repair (charge per hour * used
 *      work hours).
 */
@Validated
public class Worker extends Person {

  @Min(value = 1, message = "Hourly wage must be at least 1")
  private int hourlyWage;
  @Min(value = 1, message = "Hourly charge must be at least 1")
  private int chargePerHour;

  public int getHourlyWage() {
    return this.hourlyWage;
  }

  public void setHourlyWage(int hourlyWage) {
    this.hourlyWage = hourlyWage;
  }

  public int getChargePerHour() {
    return this.chargePerHour;
  }

  public void setChargePerHour(int chargePerHour) {
    this.chargePerHour = chargePerHour;
  }

  public Worker() {
  }
}
