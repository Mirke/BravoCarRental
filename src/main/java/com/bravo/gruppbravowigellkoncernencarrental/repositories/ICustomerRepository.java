package com.bravo.gruppbravowigellkoncernencarrental.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Long> {
    
     // @Query("SELECT c FROM Car c WHERE c.something = :something")
    // car getSomething(@Param("something") String something);
}
