package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.List;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CarDto;

public interface ICarService {
    
    void addCar(CarDto dto);
    List<Car> getCars();
    CarDto getCar(Long id);
    void updateCar(CarDto dto);
    void RemoveCar(Long id);
}
