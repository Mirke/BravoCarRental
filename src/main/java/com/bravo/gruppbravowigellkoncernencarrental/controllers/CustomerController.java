package com.bravo.gruppbravowigellkoncernencarrental.controllers;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICustomerRepository;
import com.bravo.gruppbravowigellkoncernencarrental.services.CarService;
import com.bravo.gruppbravowigellkoncernencarrental.services.CustomerService;
import com.bravo.gruppbravowigellkoncernencarrental.services.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** <code>CustomerController</code> - CRUD commands for customer
  * @authors Nicolina Larsson (Creator) / Mikael Eriksson (Editor)
  * @version 0.0.1
  */

@RestController
public class CustomerController {

    @Autowired
    private IOrdersService iOrdersService;

    // TODO - Customer version of getting cars that does not show the ones that are booked
    /*
    @GetMapping("api/v1/cars")
    public List<Customer> getCars(){return customerService.getCarsForCustomer();
    }
    */

    // TODO - Customer version of ordering a car
    /*
    @PostMapping("api/v1/ordercar")
    public Orders orderCarForCustomer(Long id){
        return iOrdersService.orderCar(id);
    }
    */

    // TODO - Customer version of canceling an order
    /*
    @PutMapping("api/v1/cancelorder")
    public Orders customerCancelsOrder(Long id){
        return iOrdersService.cancelOrder(id);
    }
    */

    // TODO - Customer version of them being able to view all of their orders.
    /*
    @GetMapping("api/v1/myorders")
    public List<Orders> customersOrders(){
        return customerService.getCustomersOrders();
    }
    */


}
