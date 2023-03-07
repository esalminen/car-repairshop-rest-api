package com.car_repairshop.rest_api.model;

/**
 * This class represents a service order for car maintenance.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 1.3.2023
 * 
 * 
 *        Service order is a reservation for car maintenance in the repair shop.
 *        It is created by customer service and it is linked to a car and a
 *        customer. Service order has a description of the work to be done.
 *        Service order is linked to a service event when the work is completed.
 *        Price of the service order is calculated from the service event based
 *        on worker's charge per hour and work hours. Service order is paid when
 *        the customer pays the bill.
 */

public class ServiceOrder {
  private Long id;
  private Long customerId;
  private String carLisencePlate;
  private Long serviceEventId;
  private String serviceOrderDescription;
  private boolean serviceOrderPaid;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(Long id) {
    this.customerId = id;
  }

  public String getCarLisencePlate() {
    return this.carLisencePlate;
  }

  public void setCarLisencePlate(String carLisencePlate) {
    this.carLisencePlate = carLisencePlate;
  }

  public Long getServiceEventId() {
    return this.serviceEventId;
  }

  public void setServiceEventId(Long serviceEventId) {
    this.serviceEventId = serviceEventId;
  }

  public String getServiceOrderDescription() {
    return this.serviceOrderDescription;
  }

  public void setServiceOrderDescription(String serviceOrderDescription) {
    this.serviceOrderDescription = serviceOrderDescription;
  }

  public boolean getServiceOrderPaid() {
    return this.serviceOrderPaid;
  }

  public void setServiceOrderPaid(boolean serviceOrderPaid) {
    this.serviceOrderPaid = serviceOrderPaid;
  }

  public ServiceOrder() {
  }
}
