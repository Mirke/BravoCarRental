package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CarDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICarRepository;
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectMapper;

/**
 * <code>CarService</code> - Service methods for car entities
 * @authors Jessica
 * @version 0.0.1
 */

@Service
public class CarService implements ICarService {

    ICarRepository carRepository;

    public CarService(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(CarDto dto) {
        carRepository.save(ObjectMapper.ConvertToCarEntity(dto));
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public List<Car> getAvaliableCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(car -> {
            if (car.isAvailable()) {
                cars.add(car);
            }
        });
        return cars;
    }

    @Override
    public CarDto getCar(Long id) {
        return ObjectMapper.ConvertToCarDto(carRepository.findById(id).get());
    }

    @Override
    public void updateCar(CarDto dto) {
        Car car = carRepository.findById(dto.getId()).get();
        carRepository.save(ObjectMapper.ConvertToCarEntity(car, dto));
    }

    @Override
    public void removeCar(Long id) {
        carRepository.deleteById(id);
    }

}
