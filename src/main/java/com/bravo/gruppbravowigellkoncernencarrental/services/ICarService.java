package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.List;

import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CarDto;

public interface ICarService {
    
    void addCar(CarDto dto);
    List<CarDto> getCars();
    CarDto getCar(Long id);
    void updateCar(CarDto dto);
    void RemoveCar(Long id);
}
