package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.List;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CarDto;

/**
 * <code>ICarService</code> - Interface for  car service  methods
 * @authors Jessica
 * @version 0.0.1
 */

public interface ICarService {
    
    boolean addCar(CarDto dto);
    List<CarDto> getCars();
    CarDto getCar(Long id);
    boolean updateCar(CarDto dto);
    boolean removeCar(Long id);
    List<Car> getAvaliableCars();
}
