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
  private Customer customer;
  private String carLisencePlate;
  private ServiceEvent serviceEvent;
  private String serviceOrderDescription;
  private boolean serviceOrderPaid;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public String getCarLisencePlate() {
    return this.carLisencePlate;
  }

  public void setCarLisencePlate(String carLisencePlate) {
    this.carLisencePlate = carLisencePlate;
  }

  public ServiceEvent getServiceEventId() {
    return this.serviceEvent;
  }

  public void setServiceEventId(ServiceEvent serviceEvent) {
    this.serviceEvent = serviceEvent;
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
