package com.bravo.gruppbravowigellkoncernencarrental.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.PushBuilder;

import com.bravo.gruppbravowigellkoncernencarrental.entities.*;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.*;

public class ObjectConverter {

    // ############### Car ################//#

    public static CarDto ConvertToCarDto(Car entity) {

        CarDto dto = new CarDto();
        dto.setCarSize(entity.getCarSize());
        dto.setId(entity.getId());
        dto.setCostPerDay(entity.getCostPerDay());
        dto.setAvailable(entity.isAvailable());
        return dto;
    }

    public static List<CarDto> ConvertToCarDto(List<Car> entities) {

        List<CarDto> dtos = new ArrayList<>();
        for (Car entity : entities) {
            CarDto dto = new CarDto();
            dto.setCarSize(entity.getCarSize());
            dto.setId(entity.getId());
            dto.setCostPerDay(entity.getCostPerDay());
            dto.setAvailable(entity.isAvailable());
            dtos.add(dto);
        }
        return dtos;
    }

    public static Car ConvertToCarEntity(CarDto dto) {

        Car entity = new Car();
        entity.setCarSize(dto.getCarSize());
        entity.setId(dto.getId());
        entity.setCostPerDay(dto.getCostPerDay());
        entity.setAvailable(dto.isAvailable());
        return entity;
    }

    public static Car ConvertToCarEntity(Car entity, CarDto dto) {

        entity.setCarSize(dto.getCarSize());
        entity.setId(dto.getId());
        entity.setCostPerDay(dto.getCostPerDay());
        entity.setAvailable(dto.isAvailable());
        return entity;
    }

    // ############### Customer ################//#

    public static CustomerDto ConvertToCustomerDto(Customer entity) {

        CustomerDto dto = new CustomerDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setStreetAddress(entity.getStreetAddress());
        dto.setPostalCode(entity.getPostalCode());
        dto.setCity(entity.getCity());

        return dto;
    }

    public static List<CustomerDto> ConvertToCustomerDto(List<Customer> entities) {

        List<CustomerDto> dtos = new ArrayList<>();
        for (Customer entity : entities) {
            CustomerDto dto = new CustomerDto();
            dto.setId(entity.getId());
            dto.setFirstName(entity.getFirstName());
            dto.setLastName(entity.getLastName());
            dto.setPhone(entity.getPhone());
            dto.setEmail(entity.getEmail());
            dto.setStreetAddress(entity.getStreetAddress());
            dto.setPostalCode(entity.getPostalCode());
            dto.setCity(entity.getCity());
            dtos.add(dto);
        }
        return dtos;
    }


    public static Customer ConvertToCustomerEntity(CustomerDto dto) {

        Customer entity = new Customer();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setStreetAddress(dto.getStreetAddress());
        entity.setPostalCode(dto.getPostalCode());
        entity.setCity(dto.getCity());

        return entity;
    }

    public static Customer ConvertToCustomerEntity(Customer entity, CustomerDto dto) {

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setStreetAddress(dto.getStreetAddress());
        entity.setPostalCode(dto.getPostalCode());
        entity.setCity(dto.getCity());

        return entity;
    }

}
