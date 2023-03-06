package com.car_repairshop.rest_api.model;

/**
 * This class represents a repairshop worker.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 23.2.2023
 * 
 * @see Person
 *      Besides of Person properties, Worker has a hourly wage and charge per
 *      hour which makes up the customer bill for repair (charge per hour * used
 *      work hours).
 */

public class Worker extends Person {
  private int hourlyWage;
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
