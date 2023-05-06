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
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(CustomerController.class);


    @GetMapping("api/v1/myorders")
    public List<Orders> getOrders(@RequestBody Customer customer){
        return orderService.getCustomerOrders(customer.getId());
}

    @GetMapping("api/v1/cars")
    public List<Car> getCars() {
        return carService.getAvaliableCars();
    }

    @PostMapping("api/v1/ordercar")
    public ResponseEntity<OrderDto> orderCar(@RequestBody OrderDto order) {
        orderService.addOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }


    @PutMapping("api/v1/cancelorder")
    public ResponseEntity<OrderDto> cancelOrder(@RequestBody OrderDto order) {
        Optional<Orders> ordersItem = iOrderRepository.findById(order.getId());
        if(ordersItem.isPresent()){
            logger.info("Customer "+ ordersItem.get().getCustomer().getFirstName() + " canceled order id " + ordersItem.get().getId());
            orderService.cancelOrder(ObjectMapper.ConvertToOrderDto(ordersItem.get()));
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        logger.info("Customer "+ order.getCustomer().getFirstName() + " failed to cancel order id " + order.getId());
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
