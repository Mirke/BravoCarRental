package com.bravo.gruppbravowigellkoncernencarrental.utilities;

import java.util.ArrayList;
import java.util.List;

// import javax.servlet.http.PushBuilder;

import com.bravo.gruppbravowigellkoncernencarrental.entities.*;
import com.bravo.gruppbravowigellkoncernencarrental.models.dto.*;

/**
 * <code>ObjectConverter</code> - Utility class for converting CarDto and
 * CustomerDto entities to Customer and Customer.
 *
 * @authors Jessica
 * @version 0.0.1
 */

public class ObjectMapper {
    // ############### Car ################//#



    public static CarDto ConvertToCarDto(Car entity) {

        CarDto dto = new CarDto();
        dto.setId(entity.getId());
        dto.setCostPerDay(entity.getCostPerDay());
        dto.setAvailable(entity.isAvailable());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        dto.setFactory(entity.getFactory());
        dto.setModel(entity.getModel());
        return dto;
    }

    public static List<CarDto> ConvertToCarDtos(List<Car> entities) {

        List<CarDto> dtos = new ArrayList<>();
        for (Car entity : entities) {
            CarDto dto = new CarDto();
            dto.setId(entity.getId());
            dto.setCostPerDay(entity.getCostPerDay());
            dto.setAvailable(entity.isAvailable());
            dto.setRegistrationNumber(entity.getRegistrationNumber());
            dto.setFactory(entity.getFactory());
            dto.setModel(entity.getModel());
            dtos.add(dto);
        }
        return dtos;
    }

    public static Car ConvertToCarEntity(CarDto dto) {

        Car entity = new Car();
        entity.setId(dto.getId());
        entity.setCostPerDay(dto.getCostPerDay());
        entity.setAvailable(dto.isAvailable());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        entity.setFactory(dto.getFactory());
        entity.setModel(dto.getModel());
        return entity;
    }

    public static Car ConvertToCarEntity(Car entity, CarDto dto) {

        entity.setId(dto.getId());
        entity.setCostPerDay(dto.getCostPerDay());
        entity.setAvailable(dto.isAvailable());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        entity.setFactory(dto.getFactory());
        entity.setModel(dto.getModel());
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

    public static List<CustomerDto> ConvertToCustomerDtos(List<Customer> entities) {

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

    // ############### Order ################//#

    public static OrderDto ConvertToOrderDto(Orders entity) {

        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());
        dto.setOrderDate(entity.getOrderDate());
        dto.setBookedFrom(entity.getBookedFrom());
        dto.setReturnDate(entity.getReturnDate());
        dto.setCar(entity.getCar());
        dto.setCustomer(entity.getCustomer());
        return dto;
    }

    public static List<OrderDto> ConvertToOrderDtos(List<Orders> entities) {

        List<OrderDto> dtos = new ArrayList<>();
        for (Orders entity : entities) {
            OrderDto dto = new OrderDto();
            dto.setId(entity.getId());
            dto.setOrderDate(entity.getOrderDate());
            dto.setBookedFrom(entity.getBookedFrom());
            dto.setReturnDate(entity.getReturnDate());
            dto.setCar(entity.getCar());
            dto.setCustomer(entity.getCustomer());
            dtos.add(dto);
        }
        return dtos;
    }

    public static Orders ConvertToOrderEntity(OrderDto dto) {
        Orders entity = new Orders();
        entity.setOrderDate(dto.getOrderDate());
        entity.setBookedFrom(dto.getBookedFrom());
        entity.setReturnDate(dto.getReturnDate());
        entity.setCar(dto.getCar());
        entity.setCustomer(dto.getCustomer());
        return entity;
    }

    public static Orders ConvertToOrderEntity(Orders entity, OrderDto dto) {

        entity.setOrderDate(dto.getOrderDate());
        entity.setBookedFrom(dto.getBookedFrom());
        entity.setReturnDate(dto.getReturnDate());
        entity.setCar(dto.getCar());
        entity.setCustomer(dto.getCustomer());
        return entity;
    }
}
