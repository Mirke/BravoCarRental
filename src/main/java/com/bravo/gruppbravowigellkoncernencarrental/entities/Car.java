package com.bravo.gruppbravowigellkoncernencarrental.entities;

import javax.persistence.*;

/**
 * <code>Car</code> - Car entity
 * @authors Karin (Creator) / Mikael Eriksson (Editor)
 * @version 0.0.1
 */

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Mikael la till
    @Column(length = 10, nullable = false)
    private String factory;

    // Mikael la till
    @Column(length = 10, nullable = false)
    private String model;

    @Column(length = 10, nullable = false)
    private int costPerDay;

    // Mikael la till
    @Column(length = 10, nullable = false)
    private String registrationNumber;

    @Column(nullable = false)
    private boolean available;

    public Car() {

    }

    public Car(Long id, String factory, String model, int costPerDay, String registrationNumber, boolean available) {
        this.id = id;
        this.factory = factory;
        this.model = model;
        this.costPerDay = costPerDay;
        this.registrationNumber = registrationNumber;
        this.available = available;
    }

    public Car(String factory, String model, int costPerDay, String registrationNumber, boolean available) {
        this.factory = factory;
        this.model = model;
        this.costPerDay = costPerDay;
        this.registrationNumber = registrationNumber;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(int costPerDay) {
        this.costPerDay = costPerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    // Mikael la till
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
