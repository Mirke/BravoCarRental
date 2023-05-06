package com.bravo.gruppbravowigellkoncernencarrental.controllers;

import com.bravo.gruppbravowigellkoncernencarrental.GruppBravoWigellkoncernenCarRentalApplication;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Orders;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CarDto;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;
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
 * @authors Mikael Eriksson (mikael.eriksson@edu.edugrade.se) (Creator and create Loggers) / Jean Kadahizi (jean.kadahizi@edu.edugrade.se) (Editor)
 * @version 0.0.1
 */

@RestController
public class AdminController {

    // -----------------------------------------------------------------------------------------------------------------
    //   Properties
    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private CarService carService;
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ICarRepository carRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    IOrderRepository iOrderRepository;
    @Autowired
    private OrderService orderService;

    private static final Logger logger = LogManager.getLogger(AdminController.class);


    // -----------------------------------------------------------------------------------------------------------------
    //   Methods CRUD
    // -----------------------------------------------------------------------------------------------------------------

    @GetMapping("api/v1/allcars")
    public List<Car> getAllCars(){return carService.getCars();}

    /**
     * <code>AdminController</code> - CRUD(add car) commands for admin
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @PostMapping("api/v1/addcar")
    public  ResponseEntity<CarDto> addCar(@RequestBody CarDto car) {
        carService.addCar(car);
        logger.info("Admin added new car " + car.getFactory() + " " + car.getModel());
        return new ResponseEntity<>(car,HttpStatus.CREATED);
    }

    /**
     * <code>AdminController</code> - CRUD(update car) commands for admin
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @PutMapping("api/v1/updatecar")
    public  ResponseEntity<CarDto> updateCar(@RequestBody CarDto car){
        Optional<Car> carItem = carRepository.findById(car.getId());
        if(carItem.isPresent()){
            logger.info("Admin updated car " + carItem.get().getFactory() + " to " + car.getFactory());
            carService.updateCar(car);
            return  new ResponseEntity<>(car,HttpStatus.OK);
        }
        logger.error("Admin couldn't update car with id: " + car.getId());
        return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    /**
     * <code>AdminController</code> - CRUD(delete car) commands for admin
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @DeleteMapping("api/v1/deletecar")
    public ResponseEntity<String> deleteCar(@RequestBody Car car){
        Optional<Car> carItem = carRepository.findById(car.getId());
        if(carItem.isPresent()){
            logger.info("Admin deleted car " + carItem.get().getFactory() + " " + carItem.get().getModel() );
            carService.removeCar(car.getId());
            return new ResponseEntity<>("Car deleted!", HttpStatus.OK);
        }
        logger.error("Admin couldn't deleted car with id: " + car.getId());
        return new ResponseEntity<>("Car not deleted!", HttpStatus.NOT_FOUND);
    }


    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers(){ return customerService.getCustomers();}


    /**
     * <code>AdminController</code> - CRUD(create new  customer) commands for admin
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     */
    @PostMapping("api/v1/addcustomer")
    public  ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customer) {
        customerService.addCustomer(customer);
        logger.info("Admin added new customer " + customer.getFirstName() + " " + customer.getLastName());
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }

    /**
     * <code>AdminController</code> - CRUD(update customer) commands for admin
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @PutMapping("api/v1/updatecustomer")
    public  ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customer){
        Optional<Customer> customerItem = customerRepository.findById(customer.getId());
        if(customerItem.isPresent()){
            logger.info("Admin updated customer " + customerItem.get().getFirstName() + " " + customerItem.get().getLastName() + " to " + customer.getFirstName() + " " + customer.getLastName());
            customerService.updateCustomer(customer);
            return  new ResponseEntity<>(customer,HttpStatus.OK);
        }
        logger.error("Admin couldn't update customer with id: " + customer.getId());
        return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }


    /**
     * <code>AdminController</code> - CRUD(delete customer) commands for admin
     * @authors Jean Kadahizi (jean.kadahizi@edu.edugrade.se)
     * @version 0.0.1
     * @return
     */
    @DeleteMapping("api/v1/deletecustomer")
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer){
        Optional<Customer> customerItem = customerRepository.findById(customer.getId());
        if(customerItem.isPresent()){
            logger.info("Admin deleted customer " + customerItem.get().getFirstName() + " " + customerItem.get().getLastName());
            customerService.RemoveCustomer(customer.getId());
            return new ResponseEntity<>("Customer deleted!", HttpStatus.OK);
        }
        logger.info("Admin couldn't delete customer with id: " + customer.getId());
        return new ResponseEntity<>("Customer not deleted!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("api/v1/orders")
    public List<Orders> getAllOrders(){
        return orderService.getAllOrders();
    }


    @DeleteMapping("api/v1/deleteorder")
    public void deleteOrder(@RequestBody Orders orders){
        orderService.removeOrder(orders.getId());
    }
}
