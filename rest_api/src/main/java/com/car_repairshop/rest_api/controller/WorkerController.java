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

import com.car_repairshop.rest_api.model.Worker;
import com.car_repairshop.rest_api.service.WorkerService;

/**
 * This class represents a controller for all workers.
 */
@RestController
@RequestMapping("/api")
public class WorkerController {

  WorkerService ws;

  /**
   * Constructor for WorkerController with dependency injection.
   * 
   * @param workerService
   */
  @Autowired
  public WorkerController(WorkerService workerService) {
    ws = workerService;
  }

  /**
   * Adds a new worker to the list. Returns the added worker with the new id.
   * 
   * @param worker
   * @return ResponseEntity<Worker>
   */
  @PostMapping("/workers")
  public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
    Worker result = ws.addWorker(worker);
    if (result != null) {
      return new ResponseEntity<Worker>(result, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<Worker>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Returns a list of all workers.
   * 
   * @return ResponseEntity<List<Worker>>
   */
  @GetMapping("/workers")
  public ResponseEntity<List<Worker>> getWorkers() {
    if (!ws.getWorkers().isEmpty()) {
      return new ResponseEntity<List<Worker>>(ws.getWorkers(), HttpStatus.OK);
    }
    return new ResponseEntity<List<Worker>>(HttpStatus.NOT_FOUND);
  }

  /**
   * Returns a worker by id.
   * 
   * @param workerId
   * @return ResponseEntity<Worker>
   */
  @GetMapping("/workers/{workerId}")
  public ResponseEntity<Worker> getWorkerByWorkerNumber(@PathVariable Long workerId) {
    Worker result = ws.getWorkerById(workerId);
    if (result != null) {
      return new ResponseEntity<Worker>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Worker>(result, HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Updates a worker by id and returns the updated worker.
   * 
   * @param workerId
   * @param worker
   * @return ResponseEntity<Worker>
   */
  @PutMapping("/workers/{workerId}")
  public ResponseEntity<Worker> updateWorker(@PathVariable Long workerId, @RequestBody Worker worker) {
    Worker result = ws.updateWorker(workerId, worker);
    if (result != null) {
      return new ResponseEntity<Worker>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Worker>(result, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * Deletes a worker by id and returns the deleted worker.
   * 
   * @param workerId
   * @return ResponseEntity<Worker>
   */
  @DeleteMapping("/workers/{workerId}")
  public ResponseEntity<Worker> deleteWorker(@PathVariable Long workerId) {
    Worker result = ws.deleteWorker(workerId);
    if (result != null) {
      return new ResponseEntity<Worker>(result, HttpStatus.OK);
    } else {
      return new ResponseEntity<Worker>(result, HttpStatus.NOT_FOUND);
    }
  }
}
