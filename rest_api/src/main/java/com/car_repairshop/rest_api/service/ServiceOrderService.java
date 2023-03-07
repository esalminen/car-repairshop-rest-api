package com.car_repairshop.rest_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.car_repairshop.rest_api.model.*;

/**
 * This class represents a serviceclass for all service orders.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 6.3.2023
 * 
 *        Class holds all the logic of handling the service order class.
 */

@Service
public class ServiceOrderService {
  private List<ServiceOrder> serviceOrders = new ArrayList<>();

  /**
   * Add a new serviceOrder to the list. Returns the added serviceOrder with the
   * new id.
   */
  public ServiceOrder addServiceOrder(ServiceOrder serviceOrder) {
    Long highestId = 0L;
    for (ServiceOrder so : serviceOrders) {
      if (so.getId() > highestId) {
        highestId = so.getId();
      }
    }
    serviceOrder.setId(highestId + 1);
    serviceOrders.add(serviceOrder);
    return serviceOrder;
  }

  /**
   * Returns a list of all serviceOrders.
   */
  public List<ServiceOrder> getServiceOrders() {
    return serviceOrders;
  }

  /**
   * Returns a serviceOrder by id.
   */
  public ServiceOrder getServiceOrderById(Long serviceOrderId) {
    for (ServiceOrder serviceOrder : serviceOrders) {
      if (serviceOrder.getId() == serviceOrderId) {
        return serviceOrder;
      }
    }
    return null;
  }

  /**
   * Returns a list of serviceOrders by customer id.
   */
  public List<ServiceOrder> getServiceOrderByCustomerId(Long customerId) {
    List<ServiceOrder> serviceOrdersByCustomerId = new ArrayList<>();
    for (ServiceOrder serviceOrder : serviceOrders) {
      if (serviceOrder.getCustomerId() == customerId) {
        serviceOrdersByCustomerId.add(serviceOrder);
      }
    }
    return serviceOrdersByCustomerId;
  }

  /**
   * Returns a list of serviceOrders by car license plate.
   */
  public List<ServiceOrder> getServiceOrderByCarLicensePlate(String carLicensePlate) {
    List<ServiceOrder> serviceOrdersByCarLicensePlate = new ArrayList<>();
    for (ServiceOrder serviceOrder : serviceOrders) {
      if (serviceOrder.getCarLisencePlate().equals(carLicensePlate)) {
        serviceOrdersByCarLicensePlate.add(serviceOrder);
      }
    }
    return serviceOrdersByCarLicensePlate;
  }

  /**
   * Returns a list of serviceOrders by service paid status.
   */
  public List<ServiceOrder> getServiceOrderByServicePaidStatus(boolean servicePaidStatus) {
    List<ServiceOrder> serviceOrdersByServicePaidStatus = new ArrayList<>();
    for (ServiceOrder serviceOrder : serviceOrders) {
      if (serviceOrder.getServiceOrderPaid() == servicePaidStatus) {
        serviceOrdersByServicePaidStatus.add(serviceOrder);
      }
    }
    return serviceOrdersByServicePaidStatus;
  }

  /**
   * Updates serviceOrder data. Returns the updated serviceOrder.
   */
  public ServiceOrder updateServiceOrder(Long serviceOrderId, ServiceOrder updatedServiceOrder) {
    ServiceOrder serviceOrder = getServiceOrderById(serviceOrderId);
    updatedServiceOrder.setId(serviceOrderId);
    if (serviceOrder != null) {
      serviceOrder = updatedServiceOrder;
      return serviceOrder;
    } else {
      return null;
    }
  }

  /**
   * Deletes a serviceOrder by id. Returns deleted serviceOrder.
   */
  public ServiceOrder deleteServiceOrder(Long serviceOrderId) {
    ServiceOrder serviceOrder = getServiceOrderById(serviceOrderId);
    if (serviceOrder != null) {
      serviceOrders.remove(serviceOrder);
      return serviceOrder;
    } else {
      return null;
    }
  }
}
