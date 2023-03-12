package com.car_repairshop.rest_api.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

/**
 * This class represents a service event for reserved car maintenance.
 * 
 * @author Esa Salminen
 * @version 1.1
 * @since 11.3.2023
 * 
 * 
 *        Service event is a completed work of a car maintenance. It is created
 *        by repairshop worker and it is linked to a service order. Service
 *        event has a description of the work done and the time it took to
 *        complete ordered work.
 */
@Validated
public class ServiceEvent {
  @NotNull(message = "Worker must not be empty")
  private Worker worker;
  @NotBlank(message = "Service description must not be empty")
  private String serviceDescription;
  @Min(value = 1, message = "Work hours must be at least 1")
  private int workHours;

  public Worker getWorker() {
    return this.worker;
  }

  public void setWorker(Worker worker) {
    this.worker = worker;
  }

  public String getServiceDescription() {
    return this.serviceDescription;
  }

  public void setServiceDescription(String serviceDescription) {
    this.serviceDescription = serviceDescription;
  }

  public int getWorkHours() {
    return this.workHours;
  }

  public void setWorkHours(int workHours) {
    this.workHours = workHours;
  }

  public ServiceEvent() {
  }
}
