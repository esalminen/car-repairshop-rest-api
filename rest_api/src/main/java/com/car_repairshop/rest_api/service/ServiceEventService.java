package com.car_repairshop.rest_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.car_repairshop.rest_api.model.*;

/**
 * This class represents a serviceclass for all service events.
 * 
 * @author Esa Salminen
 * @version 1.0
 * @since 7.3.2023
 * 
 *        Class holds all the logic of handling the service event class.
 */

@Service
public class ServiceEventService {
  private List<ServiceEvent> serviceEvents = new ArrayList<>();

  /**
   * Add a new serviceEvent to the list. Returns the added serviceEvent with the
   * new id.
   */
  public ServiceEvent addServiceEvent(ServiceEvent serviceEvent) {
    Long highestId = 0L;
    for (ServiceEvent se : serviceEvents) {
      if (se.getId() > highestId) {
        highestId = se.getId();
      }
    }
    serviceEvent.setId(highestId + 1);
    serviceEvents.add(serviceEvent);
    return serviceEvent;
  }

  /**
   * Returns a list of all serviceEvents.
   */
  public List<ServiceEvent> getServiceEvents() {
    return serviceEvents;
  }

  /**
   * Returns a serviceEvent by id.
   */
  public ServiceEvent getServiceEventById(Long serviceEventId) {
    for (ServiceEvent serviceEvent : serviceEvents) {
      if (serviceEvent.getId() == serviceEventId) {
        return serviceEvent;
      }
    }
    return null;
  }

  /**
   * Updates serviceEvent data. Returns the updated serviceEvent.
   */
  public ServiceEvent updateServiceEvent(Long serviceEventId, ServiceEvent updatedServiceEvent) {
    ServiceEvent serviceEvent = getServiceEventById(serviceEventId);
    updatedServiceEvent.setId(serviceEventId);
    if (serviceEvent != null) {
      int serviceEventIndex = serviceEvents.indexOf(serviceEvent);
      serviceEvents.set(serviceEventIndex, updatedServiceEvent);
      return updatedServiceEvent;
    } else {
      return null;
    }
  }

  /**
   * Deletes a serviceEvent by id. Returns deleted serviceEvent.
   */
  public ServiceEvent deleteServiceEvent(Long serviceEventId) {
    ServiceEvent serviceEvent = getServiceEventById(serviceEventId);
    if (serviceEvent != null) {
      serviceEvents.remove(serviceEvent);
      return serviceEvent;
    } else {
      return null;
    }
  }
}
