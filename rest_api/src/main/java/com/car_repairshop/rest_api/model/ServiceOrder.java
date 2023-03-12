package com.car_repairshop.rest_api.model;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

/**
 * This class represents a service order for car maintenance.
 * 
 * @author Esa Salminen
 * @version 1.1
 * @since 11.3.2023
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

@Validated
public class ServiceOrder {
  private Long id;
  @NotBlank(message = "Customer must not be empty")
  private Customer customer;
  @NotBlank(message = "Car license plate must not be empty")
  private String carLicensePlate;
  private ServiceEvent serviceEvent;
  @NotBlank(message = "Service order description must not be empty")
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

  public String getCarLicensePlate() {
    return this.carLicensePlate;
  }

  public void setCarLicensePlate(String carLisencePlate) {
    this.carLicensePlate = carLisencePlate;
  }

  public ServiceEvent getServiceEvent() {
    return this.serviceEvent;
  }

  public void setServiceEvent(ServiceEvent serviceEvent) {
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
