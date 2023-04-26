package com.bravo.gruppbravowigellkoncernencarrental.controllers;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CarDto;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICarRepository;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICustomerRepository;
import com.bravo.gruppbravowigellkoncernencarrental.services.CarService;
import com.bravo.gruppbravowigellkoncernencarrental.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // TODO - Needs OrderService

    @Autowired
    private CarService carService;
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ICarRepository carRepository;
    @Autowired
    private CustomerService customerService;


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
        System.out.println("Admin added new car");
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
            carService.updateCar(car);
            System.out.println("admin updated car");
            return  new ResponseEntity<>(car,HttpStatus.OK);
        }

        return  new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
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
            carService.RemoveCar(car.getId());
            return new ResponseEntity<>("Car deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Car not deleted!", HttpStatus.NO_CONTENT);
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
        System.out.println("Admin added new car");
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
            customerService.updateCustomer(customer);
            System.out.println("admin updated customer");
            return  new ResponseEntity<>(customer,HttpStatus.OK);
        }

        return  new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
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
            customerService.RemoveCustomer(customer.getId());
            return new ResponseEntity<>("Customer deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Customer not deleted!", HttpStatus.NO_CONTENT);
    }



}
