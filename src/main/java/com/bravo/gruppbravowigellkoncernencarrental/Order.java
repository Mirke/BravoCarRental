package com.bravo.gruppbravowigellkoncernencarrental;

import com.bravo.gruppbravowigellkoncernencarrental.entities.Car;
import com.bravo.gruppbravowigellkoncernencarrental.entities.Customer;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long OrderID;

    public Long getId() {
        return OrderID;
    }

    public void setId(Long id) {
        this.OrderID = id;
    }

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    public Order() {
    }

    public Order(Long orderID, Car car, Customer customer) {
        OrderID = orderID;
        this.car = car;
        this.customer = customer;
    }

    public Long getOrderID() {
        return OrderID;
    }

    public void setOrderID(Long orderID) {
        OrderID = orderID;
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