package com.bravo.gruppbravowigellkoncernencarrental.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * * <code>Order</code> - Order Entity
 * @Authors Nicolina Larsson, Karin (Created)
 * @version 0.0.1
 * */

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date orderDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date bookedFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date returnDate;

    @OneToOne
    @JoinColumn(name = "CarId")
    private Car car;

    @OneToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;

    public Orders() {
    }

    public Orders(Long id) {
        this.id = id;
    }


    public Orders(Long id, Date orderDate, Date bookedFrom, Date returnDate, Car car) {
        this.id = id;
        this.orderDate = orderDate;
        this.bookedFrom = bookedFrom;
        this.returnDate = returnDate;
        this.car = car;
    }

    public Orders(Long id, Date orderDate, Date bookedFrom, Date returnDate, Car car, Customer customer) {
        this.id = id;
        this.orderDate = orderDate;
        this.bookedFrom = bookedFrom;
        this.returnDate = returnDate;
        this.car = car;
        this.customer = customer;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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