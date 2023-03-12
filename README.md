# car-repairshop-rest-api
Spring Boot REST API for fictional repairshop for cars. Java programming course final project. 

## Description
Purpose of this REST-API is that fictional repairshop manager can keep customer, car, worker and service orders related data 
in control.

Example workflow with REST-API

1. Manager enters all repairshop workers to the system
2. Manager inserts a new customer and customers cars to the system.
3. Manager inserts a new service order for a customers car to the system.
4. Carshop worker goes to see from user interface if there is any work to be done
5. Worker sees the created service order with detailed service description
6. Worker marks the service order for himself and starts working.
7. After work is completed, worker inserts used workhours and optional comment to the service order
8. Manager gets notification that worker has completed the service order
9. Manager notifies the customer, which comes to the repair shop to pick up the car
10. If customer decides to pay the service while retaining the car, service order is marked accordinly
11. If customer wants an invoice, service order is marked with information that customer has not yet paid it
12. When customer pays the invoice, manager marks the service order to paid - status

### Customer

* [Post a customer](#) : `POST /api/customers/`
* [Get all customers](#) : `GET /api/customers/`
* [Get a customer](#) : `GET /api/customers/:customerId(long)/`
* [Update a customer](#) : `PUT /api/customers/:customerId(long)/`
* [Delete a customer](#) : `DELETE /api/customers/:customerId(long)/`

#### Customer cars
* [Post a customers car](#) : `POST /api/customers/:customerId(long)/cars/`
* [Get all customers cars](#) : `GET /api/customers/:customerId(long)/cars/`
* [Get a customers car](#) : `GET /api/customers/:customerId(long)/cars/:licensePlate(string)/`
* [Update a customers car](#) : `PUT /api/customers/:customerId(long)/cars/:licensePlate(string)/`
* [Delete a customers car](#) : `DELETE /api/customers/:customerId(long)/cars/:licensePlate(string)/`

### Worker

* [Post a worker](#) : `POST /api/workers/`
* [Get all workers](#) : `GET /api/workers/`
* [Get a worker](#) : `GET /api/workers/:workerId(long)/`
* [Update a worker](#) : `PUT /api/workers/:workerId(long)/`
* [Delete a worker](#) : `DELETE /api/workers/:workerId(long)/`

### Service orders

* [Post a serviceorder](#) : `POST /api/serviceorders/`
* [Post a service event to service order](#) : `POST /api/serviceorders/:serviceOrderId(long)/serviceevent/`
* [Get all serviceorders](#) : `GET /api/serviceorders/`
* [Get a serviceorder](#) : `GET /api/serviceorders/:serviceOrderId(long)/`
* [Update a serviceorder](#) : `PUT /api/serviceorders/:serviceOrderId(long)/`
* [Delete a serviceorder](#) : `DELETE /api/serviceorders/:serviceOrderId(long)/`

#### Service order search routes

* [Get all service orders by car license plate](#) : `POST /api/serviceorders/car/:licensePlate(string)/`
* [Get all service orders by customer id](#) : `GET /api/serviceorders/customer/:customerId(long)/`
* [Get all service orders by invoice paid status](#) : `GET /api/serviceorders/:invoicePaid(bool)/`
