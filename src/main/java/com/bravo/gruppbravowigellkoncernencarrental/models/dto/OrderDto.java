package com.bravo.gruppbravowigellkoncernencarrental.models.dto;

import java.util.Date;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDto {
    
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date orderDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date bookedFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date returnDate;
    private Car car;
    private Customer customer;

    public OrderDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(Date bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
