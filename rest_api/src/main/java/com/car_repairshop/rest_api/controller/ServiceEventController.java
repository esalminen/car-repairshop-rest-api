package com.car_repairshop.rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.car_repairshop.rest_api.service.ServiceEventService;

/**
 * This class represents a controller for service events.
 */
@RestController
@RequestMapping("/api")
public class ServiceEventController {

  ServiceEventService ses;

  /**
   * Constructor for ServiceEventController with dependency injection.
   * 
   * @param serviceEventService
   */
  @Autowired
  public ServiceEventController(ServiceEventService serviceEventService) {
    ses = serviceEventService;
  }

  /**
   * Adds a new serviceEvent to the list. Returns the added serviceEvent with the
   * new id.
   * 
   * @param serviceEvent
   * @return ResponseEntity<ServiceEvent>
   */
  @PostMapping("/serviceevents")
  public ResponseEntity<ServiceEvent> addServiceEvent(@RequestBody ServiceEvent serviceEvent) {
    ServiceEvent result = ses.addServiceEvent(serviceEvent);
    if (result != null) {
      return new ResponseEntity<ServiceEvent>(result, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<ServiceEvent>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Returns a list of all serviceEvents.
   * 
   * @return ResponseEntity<List<ServiceEvent>>
   */
  @GetMapping("/serviceevents")
  public ResponseEntity<List<ServiceEvent>> getServiceEvents() {
    if (!ses.getServiceEvents().isEmpty()) {
      return new ResponseEntity<List<ServiceEvent>>(ses.getServiceEvents(), HttpStatus.OK);
    }
    return new ResponseEntity<List<ServiceEvent>>(HttpStatus.NOT_FOUND);
  }

  /**
   * Returns a serviceEvent by id.
   * 
   * @param serviceEventId
   * @return ResponseEntity<ServiceEvent>
   */
  @GetMapping("/serviceevents/{serviceEventId}")
  public ResponseEntity<ServiceEvent> getServiceEventByServiceEventNumber(@PathVariable Long serviceEventId) {
    ServiceEvent result = ses.getServiceEventById(serviceEventId);
    if (result != null) {
      return new ResponseEntity<ServiceEvent>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<ServiceEvent>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Updates a serviceEvent by id and returns the updated serviceEvent.
   * 
   * @param serviceEventId
   * @param serviceEvent
   * @return ResponseEntity<ServiceEvent>
   */
  @PutMapping("/serviceevents/{serviceEventId}")
  public ResponseEntity<ServiceEvent> updateServiceEvent(@PathVariable Long serviceEventId,
      @RequestBody ServiceEvent serviceEvent) {
    ServiceEvent result = ses.updateServiceEvent(serviceEventId, serviceEvent);
    if (result != null) {
      return new ResponseEntity<ServiceEvent>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<ServiceEvent>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Deletes a serviceEvent by id and returns the deleted serviceEvent.
   * 
   * @param serviceEventId
   * @return ResponseEntity<ServiceEvent>
   */
  @DeleteMapping("/serviceevents/{serviceEventId}")
  public ResponseEntity<ServiceEvent> deleteServiceEvent(@PathVariable Long serviceEventId) {
    ServiceEvent result = ses.deleteServiceEvent(serviceEventId);
    if (result != null) {
      return new ResponseEntity<ServiceEvent>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<ServiceEvent>(result, HttpStatus.NOT_FOUND);
    }
  }
}
