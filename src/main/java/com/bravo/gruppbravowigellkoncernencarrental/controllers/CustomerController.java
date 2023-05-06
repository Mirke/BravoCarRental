package com.bravo.gruppbravowigellkoncernencarrental.controllers;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CarDto;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.OrderDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICarRepository;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICustomerRepository;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.IOrderRepository;
import com.bravo.gruppbravowigellkoncernencarrental.services.CarService;
import com.bravo.gruppbravowigellkoncernencarrental.services.CustomerService;
import com.bravo.gruppbravowigellkoncernencarrental.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.ID;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/** <code>CustomerController</code> - CRUD commands for customers
  * @authors Nicolina Larsson
  * @version 0.0.1
  */

@RestController
public class CustomerController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CarService carService;
    @Autowired
    private IOrderRepository iOrderRepository;
    @Autowired
    private ICarRepository iCarRepository;


    @GetMapping("api/v1/myOrders")
    public List<Orders> getOrders(){
        return orderService.getAllOrders();
}

    @GetMapping("api/v1/allCars")
    public List<Car> getCars(){
        return carService.getCars();
    }

    @PostMapping("api/v1/orderCar")
    public ResponseEntity<Orders> orderCar(@RequestBody Orders order){
        orderService.addOrder(new OrderDto());
        System.out.println("A car was successfully ordered");
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

   @PutMapping("/admin/cancelOrder")
    public ResponseEntity<Orders> removeOrder(@RequestBody Orders order){
        return ResponseEntity.ok(orderService.removeOrder(order, id));
    }

}
