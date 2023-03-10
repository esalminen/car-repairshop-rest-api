package com.car_repairshop.rest_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.car_repairshop.rest_api.model.*;

/**
 * This class represents a serviceclass for all workers.
 * 
 * @author Esa Salminen
 * @version 1.1
 * @since 10.3.2023
 * 
 *        Class holds all the logic of handling the worker classes.
 */

@Service
public class WorkerService {
  private List<Worker> workers = new ArrayList<>();

  /**
   * Add a new worker to the list. Returns the added worker with the new id.
   */
  public Worker addWorker(Worker worker) {
    Long highestId = 0L;
    for (Worker w : workers) {
      if (w.getId() > highestId) {
        highestId = w.getId();
      }
    }
    worker.setId(highestId + 1);
    workers.add(worker);
    return worker;
  }

  /**
   * Returns a list of all workers.
   */
  public List<Worker> getWorkers() {
    return workers;
  }

  /**
   * Returns a worker by id.
   */
  public Worker getWorkerById(Long workerId) {
    for (Worker worker : workers) {
      if (worker.getId() == workerId) {
        return worker;
      }
    }
    return null;
  }

  /**
   * Updates worker data. Returns the updated worker.
   */
  public Worker updateWorker(Long workerId, Worker updatedWorker) {
    Worker worker = getWorkerById(workerId);
    updatedWorker.setId(workerId);
    if (worker != null) {
      int workerIndex = workers.indexOf(worker);
      workers.set(workerIndex, updatedWorker);
      return updatedWorker;
    } else {
      return null;
    }
  }

  /**
   * Deletes a worker by id. Returns deleted worker.
   */
  public Worker deleteWorker(Long workerId) {
    Worker worker = getWorkerById(workerId);
    if (worker != null) {
      workers.remove(worker);
      return worker;
    } else {
      return null;
    }
  }
}
