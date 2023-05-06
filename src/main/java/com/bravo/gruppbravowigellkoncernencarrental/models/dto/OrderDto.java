package com.bravo.gruppbravowigellkoncernencarrental.models.dto;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDto {
    
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date orderDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date bookedFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date returnDate;
    private CarDto car;
    private CustomerDto customer;

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

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
