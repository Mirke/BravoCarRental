package com.bravo.gruppbravowigellkoncernencarrental.controllers;

import org.springframework.web.bind.annotation.RestController;

/**
 * <code>AdminController</code> - CRUD commands for admin
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se)
 * @version 0.0.1
 */

@RestController
public class AdminController {

    // -----------------------------------------------------------------------------------------------------------------
    //   Properties
    // -----------------------------------------------------------------------------------------------------------------

    // TODO - Needs Property Admin Services

    /*
    @Autowired
    private AdminService adminService;
    */


    // -----------------------------------------------------------------------------------------------------------------
    //   Methods CRUD
    // -----------------------------------------------------------------------------------------------------------------

    // TODO - Needs @GetMapping, for "api/v1/allcars", which uses admin Service to get all cars in database

    /*
    @GetMapping("api/v1/allcars")
    public List<Car> getAllCars(){return adminService.getAllCars();}
    */

    // TODO - Needs @PostMapping, for "api/v1/addcar", which uses admin Service to add car to database

    /*
    @PostMapping("api/v1/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return new ResponseEntity<Car>(adminService.addCar(car), HttpStatus.OK);
    }
    */

    // TODO - Needs @DeleteMapping, for "api/v1/deletecar", which uses admin Service to delete a car in database

    /*
    @DeleteMapping("api/v1/deletecar")
    public ResponseEntity<String> deleteCar(@RequestBody Car car){
        adminService.deleteCar(car.getId());
        return new ResponseEntity<>("Car deleted!", HttpStatus.OK);
    }
    */

    // TODO - Needs @PutMapping, for "api/v1/updatecar", which uses admin Service to update a car to database

    /*
    @PutMapping("api/v1/updatecar")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        return ResponseEntity.ok(adminService.updateCar(car, car.getId()));
    }
    */

    // TODO - Needs @GetMapping, for "api/v1/customers", which uses admin Service get all customers in database

    /*
    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers(){ return adminService.getCustomers();}
    */

    // TODO - Needs @PostMapping, for "api/v1/addcustomer", which uses admin Service to add a customer to database

    /*
    @PostMapping("api/v1/addcustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(adminService.addCustomer(customer),HttpStatus.OK);
    }
    */

    // TODO - Needs @PutMapping, for "api/v1/updatecustomer", which uses admin Service to update a customer in database

    /*
    @PutMapping("api/v1/updatecustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(adminService.updateCustomer(customer, customer.getId()));
    }
    */

    // TODO - Needs @DeleteMapping, for "api/v1/deletecustomer", which uses admin Service to delete a customer in database

    /*
    @DeleteMapping("api/v1/deletecustomer")
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer){
        adminService.deleteCustomer(customer.getId());
        return new ResponseEntity<>("Customer deleted!", HttpStatus.OK);
    }
    */

    // TODO - Needs @GetMapping, for "api/v1/orders", which uses admin Service to get all orders in database

    /*
    @GetMapping("api/v1/orders")
    public List<Order> getAllOrders(){ return adminService.getOrders();}
    */

    // TODO - Needs @DeleteMapping, for "api/v1/deleteorder", which uses admin Service to remove a order in database

    /*
    @DeleteMapping("api/v1/deleteorder")
    public ResponseEntity<Order> deleteOrder(@RequestBody Order order){
        adminService.deleteOrder(order.getId());
        return new ResponseEntity<>("Order deleted!", HttpStatus.OK);
    }
    */
}
