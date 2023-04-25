package com.bravo.gruppbravowigellkoncernencarrental.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;

/**
 * <code>ICarRepository</code> - Crud repository for Car entities
 * @authors Jessica
 * @version 0.0.1
 */

@Repository
public interface ICarRepository extends CrudRepository<Car, Long> {
    
   
}
