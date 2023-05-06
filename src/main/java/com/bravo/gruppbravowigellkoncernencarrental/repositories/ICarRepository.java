package com.bravo.gruppbravowigellkoncernencarrental.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;

/**
 * <code>ICarRepository</code> - Crud repository for Car entities
 * @authors Jessica
 * @version 0.0.1
 */

@Repository
public interface ICarRepository extends CrudRepository<Car, Long> {
    
    @Query("SELECT c FROM Car c WHERE c.available = true")
    List<Car> getAvaliableCars();

    @Query("SELECT c FROM Car c WHERE c.available = false")
    List<Car> getBookedCars();

    @Query("SELECT c FROM Car c WHERE c.costPerDay = :costPerDay")
    List<Car> getCostPerDayCars(@Param("costPerDay") Integer costPerDay);

    @Query("SELECT c FROM Car c WHERE c.carSize = :carSize")
    List<Car> getCarSize(@Param("carSize") String carSize);
}
