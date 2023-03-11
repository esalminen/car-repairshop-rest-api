package com.car_repairshop.rest_api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car_repairshop.rest_api.model.ServiceEvent;
import com.car_repairshop.rest_api.model.ServiceOrder;
import com.car_repairshop.rest_api.service.ServiceOrderService;

/**
 * This class represents a controller for serviceorders.
 */
@RestController
@RequestMapping("/api")
public class ServiceOrderController {

  ServiceOrderService sos;

  /**
   * Constructor for ServiceOrderController with dependency injection.
   * 
   * @param serviceOrderService
   */
  public ServiceOrderController(ServiceOrderService serviceOrderService) {
    sos = serviceOrderService;
  }

  /**
   * Adds a new serviceOrder to the list. Returns the added serviceOrder with the
   * new id.
   * 
   * @param serviceOrder
   * @return ResponseEntity<ServiceOrder>
   */
  @PostMapping("/serviceorders")
  public ResponseEntity<ServiceOrder> addServiceOrder(@Valid @RequestBody ServiceOrder serviceOrder) {
    ServiceOrder result = sos.addServiceOrder(serviceOrder);
    if (result != null) {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Adds a new serviceEvent to the serviceOrder. Returns the service order.
   * 
   * @param serviceEvent
   * @param serviceOrderId
   * @return ResponseEntity<ServiceOrder>
   */
  @PostMapping("/serviceorders/{serviceOrderId}/serviceevent")
  public ResponseEntity<ServiceOrder> addServiceEventToServiceOrder(@PathVariable Long serviceOrderId,
      @Valid @RequestBody ServiceEvent serviceEvent) {
    ServiceOrder result = sos.addServiceEventToServiceOrder(serviceOrderId, serviceEvent);
    if (result != null) {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Returns a list of all serviceOrders.
   * 
   * @return ResponseEntity<List<ServiceOrder>>
   */
  @GetMapping("/serviceorders")
  public ResponseEntity<List<ServiceOrder>> getServiceOrders() {
    if (sos.getServiceOrders() != null) {
      return new ResponseEntity<List<ServiceOrder>>(sos.getServiceOrders(), HttpStatus.OK);
    }
    return new ResponseEntity<List<ServiceOrder>>(HttpStatus.NOT_FOUND);
  }

  /**
   * Returns a serviceOrder by id.
   * 
   * @param serviceOrderId
   * @return ResponseEntity<ServiceOrder>
   */
  @GetMapping("/serviceorders/{serviceOrderId}")
  public ResponseEntity<ServiceOrder> getServiceOrderByServiceOrderNumber(@PathVariable Long serviceOrderId) {
    ServiceOrder result = sos.getServiceOrderById(serviceOrderId);
    if (result != null) {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Returns a list of serviceOrders by customer id.
   * 
   * @param customerId
   * @return ResponseEntity<List<ServiceOrder>>
   */
  @GetMapping("/serviceorders/customer/{customerId}")
  public ResponseEntity<List<ServiceOrder>> getServiceOrdersByCustomerId(@PathVariable Long customerId) {
    List<ServiceOrder> result = sos.getServiceOrderByCustomerId(customerId);
    if (!result.isEmpty()) {
      return new ResponseEntity<List<ServiceOrder>>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<List<ServiceOrder>>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Returns a list of serviceOrders by car license plate.
   * 
   * @param licensePlate
   * @return ResponseEntity<List<ServiceOrder>>
   */
  @GetMapping("/serviceorders/car/{licensePlate}")
  public ResponseEntity<List<ServiceOrder>> getServiceOrdersByLicensePlate(@PathVariable String licensePlate) {
    List<ServiceOrder> result = sos.getServiceOrderByCarLicensePlate(licensePlate);
    if (!result.isEmpty()) {
      return new ResponseEntity<List<ServiceOrder>>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<List<ServiceOrder>>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Returns a list of serviceOrders by invoice paid status.
   * 
   * @param condition
   * @return ResponseEntity<List<ServiceOrder>>
   */
  @GetMapping("/serviceorders/invoicepaid/{condition}")
  public ResponseEntity<List<ServiceOrder>> getServiceOrdersByInvoicePaid(@PathVariable Boolean condition) {
    List<ServiceOrder> result = sos.getServiceOrderByServicePaidStatus(condition);
    if (!result.isEmpty()) {
      return new ResponseEntity<List<ServiceOrder>>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<List<ServiceOrder>>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Updates a serviceOrder by id and returns the updated serviceOrder.
   * 
   * @param serviceOrderId
   * @param serviceOrder
   * @return ResponseEntity<ServiceOrder>
   */
  @PutMapping("/serviceorders/{serviceOrderId}")
  public ResponseEntity<ServiceOrder> updateServiceOrder(@PathVariable Long serviceOrderId,
      @Valid @RequestBody ServiceOrder serviceOrder) {
    ServiceOrder result = sos.updateServiceOrder(serviceOrderId, serviceOrder);
    if (result != null) {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Deletes a serviceOrder by id and returns the deleted serviceOrder.
   * 
   * @param serviceOrderId
   * @return ResponseEntity<ServiceOrder>
   */
  @DeleteMapping("/serviceorders/{serviceOrderId}")
  public ResponseEntity<ServiceOrder> deleteServiceOrder(@PathVariable Long serviceOrderId) {
    ServiceOrder result = sos.deleteServiceOrder(serviceOrderId);
    if (result != null) {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<ServiceOrder>(result, HttpStatus.NOT_FOUND);
    }
  }
}
