package com.bravo.gruppbravowigellkoncernencarrental.controller;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("POST/api/v1/ordercar")
    public ResponseEntity<Order> saveOrder(@RequestBody com.bravo.gruppbravowigellkoncernencarrental.entities.Order order){
        return new ResponseEntity<Order>((Order) customerService.saveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("GET/api/v1/cars")
    public List<com.bravo.gruppbravowigellkoncernencarrental.entities.Car> getAllCars(){
        return customerService.getAllCars();
    }


    @PutMapping("PUT/api/v1/cancelorder")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") int id){
        customerService.cancelOrder(id);
        return new ResponseEntity<String>("Order cancelled!", HttpStatus.OK);
    }

    @GetMapping("GET/api/v1/myorders")
    public List<com.bravo.gruppbravowigellkoncernencarrental.entities.Order> getAllOrders(){
        return customerService.getAllOrders();
    }


}
