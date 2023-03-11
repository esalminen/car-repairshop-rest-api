package com.car_repairshop.rest_api.model;

/**
 * This class represents a service event for reserved car maintenance.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 1.3.2023
 * 
 * 
 *        Service event is a completed work of a car maintenance. It is created
 *        by repairshop worker and it is linked to a service order. Service
 *        event has a description of the work done and the time it took to
 *        complete ordered work.
 */

public class ServiceEvent {
  private Worker worker;
  private String serviceDescription;
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
