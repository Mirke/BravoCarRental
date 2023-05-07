package com.bravo.gruppbravowigellkoncernencarrental.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CarDto;
import com.bravo.gruppbravowigellkoncernencarrental.repositories.ICarRepository;
import com.bravo.gruppbravowigellkoncernencarrental.utilities.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * <code>CarService</code> - Service methods for car entities
 * 
 * @authors Jessica
 * @version 0.0.1
 */

@Service
public class CarService implements ICarService {

    private final ICarRepository carRepository;
    private static final Logger logger = LogManager.getLogger(CarService.class);

    public CarService(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public boolean addCar(CarDto dto) {
        try {
            carRepository.save(ObjectMapper.ConvertToCarEntity(dto));
            logger.info("Admin added new car " + dto.getFactory() + " " + dto.getModel());
            return true;
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    @Override
    public List<CarDto> getCars() {
        try {
            List<Car> cars = new ArrayList<>();
            carRepository.findAll().forEach(cars::add);
            return ObjectMapper.ConvertToCarDtos(cars);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public List<Car> getAvaliableCars() {
        try {
            List<Car> cars = new ArrayList<>();
            carRepository.findAll().forEach(car -> {
                if (car.isAvailable()) {
                    cars.add(car);
                }
            });
            return cars;
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public CarDto getCar(Long id) {
        try {
            Optional<Car> car = carRepository.findById(id);
            if (car.isPresent()) {
                return ObjectMapper.ConvertToCarDto(car.get());
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    @Override
    public boolean updateCar(CarDto dto) {
        try {
            Optional<Car> car = carRepository.findById(dto.getId());
            if (car.isPresent()) {
                carRepository.save(ObjectMapper.ConvertToCarEntity(car.get(), dto));
                logger.info("Admin updated car " + car.get().getFactory() + " to " + dto.getFactory());
                return true;
            }
        } catch (Exception e) {
            logger.error("Admin couldn't update car with id: " + dto.getId());
            logger.error(e);
        }
        return false;
    }

    @Override
    public boolean removeCar(Long id) {
        try {
            Optional<Car> car = carRepository.findById(id);
            if (car.isPresent()) {
                carRepository.deleteById(id);
                logger.info("Admin deleted car " + car.get().getFactory() + " " + car.get().getModel());
                return true;
            }
        } catch (Exception e) {
            logger.error("Admin couldn't deleted car with id: " + id);
            logger.error(e);
        }
        return false;
    }

}
