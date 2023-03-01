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
  private Long id;
  private Long serviceOrderId;
  private Long workerId;
  private String serviceDescription;
  private int workHours;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getServiceOrderId() {
    return this.serviceOrderId;
  }

  public void setServiceOrderId(Long serviceOrderId) {
    this.serviceOrderId = serviceOrderId;
  }

  public Long getWorkerId() {
    return this.workerId;
  }

  public void setWorkerId(Long workerId) {
    this.workerId = workerId;
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

  public ServiceEvent(Long serviceOrderId, String serviceDescription, int workHours) {
    this.serviceOrderId = serviceOrderId;
    this.serviceDescription = serviceDescription;
    this.workHours = workHours;
  }
}
