package com.bravo.gruppbravowigellkoncernencarrental.entities;

import javax.persistence.*;

/**
 * * <code>Order</code> - Order Entity
 * @Authors Nicolina Larsson
 * @version 0.0.1
 * */

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;

    public Orders() {
    }

    public Orders(Car car, Customer customer) {
        this.car = car;
        this.customer = customer;
    }

    public Orders(Long id) {
        this.id = id;
        this.car = car;
        this.customer = customer;
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