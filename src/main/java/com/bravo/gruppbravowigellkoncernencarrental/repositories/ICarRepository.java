package com.bravo.gruppbravowigellkoncernencarrental.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;

@Repository
public interface ICarRepository extends CrudRepository<Car, Long> {
    
   
}
