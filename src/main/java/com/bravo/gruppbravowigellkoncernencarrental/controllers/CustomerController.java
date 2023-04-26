package com.bravo.gruppbravowigellkoncernencarrental.controllers;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICustomerRepository;
import com.bravo.gruppbravowigellkoncernencarrental.services.CarService;
import com.bravo.gruppbravowigellkoncernencarrental.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** <code>CustomerController</code> - CRUD commands for customer
  * @authors Nicolina Larsson
  * @version 0.0.1
  */

@RestController
public class CustomerController {
    @Autowired
     private CustomerService customerService;


    @GetMapping("api/v1/allCustomers")
    public List<Customer> getCustomers(){return customerService.getCustomers();
    }

  /*  @PutMapping("/admin/v1/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer.getId());
        return ResponseEntity.ok(customerService.updateCustomer(Customer, customer.getId()));
    }*/


    @DeleteMapping("/admin/v1/delete/ID")
    public ResponseEntity<String> removeCustomer(@PathVariable ("id") long id){
        customerService.RemoveCustomer(id);
        return new ResponseEntity<String>("Customer deleted", HttpStatus.OK);
    }
}
