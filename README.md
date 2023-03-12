## car-repairshop-rest-api
Spring Boot REST API for fictional repairshop for cars. Java programming course final project. 

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
