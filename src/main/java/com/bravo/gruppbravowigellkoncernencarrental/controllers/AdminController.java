package com.bravo.gruppbravowigellkoncernencarrental.controllers;

import com.bravo.gruppbravowigellkoncernencarrental.GruppBravoWigellkoncernenCarRentalApplication;
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
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <code>AdminController</code> - CRUD commands for admin
 * 
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se) (Creator and
 *          create Loggers) / Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
 *          (Editor)
 * @version 0.0.1
 */

@RestController
public class AdminController {

    // -----------------------------------------------------------------------------------------------------------------
    // Properties
    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private CarService carService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    private static final Logger logger = LogManager.getLogger(AdminController.class);

    // -----------------------------------------------------------------------------------------------------------------
    // Methods CRUD
    // -----------------------------------------------------------------------------------------------------------------

    @GetMapping("api/v1/allcars")
    public List<CarDto> getAllCars() {
        return carService.getCars();
    }

    /**
     * <code>AdminController</code> - CRUD(add car) commands for admin
     * 
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @PostMapping("api/v1/addcar")
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto car) {
        if (carService.addCar(car)) {
            return new ResponseEntity<>(car, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    /**
     * <code>AdminController</code> - CRUD(update car) commands for admin
     * 
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @PutMapping("api/v1/updatecar")
    public ResponseEntity<CarDto> updateCar(@RequestBody CarDto car) {
        if (carService.updateCar(car)) {
            return new ResponseEntity<>(car, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * <code>AdminController</code> - CRUD(delete car) commands for admin
     * 
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @DeleteMapping("api/v1/deletecar")
    public ResponseEntity<String> deleteCar(@RequestBody Car car) {
        if (carService.removeCar(car.getId())) {
            return new ResponseEntity<>("Car deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Car not deleted!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    /**
     * <code>AdminController</code> - CRUD(create new customer) commands for admin
     * 
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     */
    @PostMapping("api/v1/addcustomer")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customer) {
        if(customerService.addCustomer(customer)){
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    /**
     * <code>AdminController</code> - CRUD(update customer) commands for admin
     * 
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @PutMapping("api/v1/updatecustomer")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customer) {
       
        if (customerService.updateCustomer(customer)) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * <code>AdminController</code> - CRUD(delete customer) commands for admin
     * 
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @DeleteMapping("api/v1/deletecustomer")
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) {
        if (customerService.RemoveCustomer(customer.getId())) {
            return new ResponseEntity<>("Customer deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Customer not deleted!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("api/v1/orders")
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("api/v1/deleteorder")
    public ResponseEntity<String> deleteOrder(@RequestBody Orders orders) {
        if (orderService.removeOrder(orders.getId())) {
            return new ResponseEntity<>("Deleted order!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Could not delete orderId: " + orders.getId(), HttpStatus.NOT_FOUND);
    }
}
