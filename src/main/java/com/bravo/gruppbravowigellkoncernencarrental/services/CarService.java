package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CarDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICarRepository;
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectConverter;

@Service
public class CarService implements ICarService {

    ICarRepository carRepository;

    public CarService(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(CarDto dto) {
        carRepository.save(ObjectConverter.ConvertToCarEntity(dto));
    }

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(cars::add);
        return cars;
    }

    @Override
    public CarDto getCar(Long id) {
        return ObjectConverter.ConvertToCarDto(carRepository.findById(id).get());
    }

    @Override
    public void updateCar(CarDto dto) {
        Car car = carRepository.findById(dto.getId()).get();
        carRepository.save(ObjectConverter.ConvertToCarEntity(car, dto));
    }

    @Override
    public void RemoveCar(Long id) {
        carRepository.deleteById(id);
    }

}
