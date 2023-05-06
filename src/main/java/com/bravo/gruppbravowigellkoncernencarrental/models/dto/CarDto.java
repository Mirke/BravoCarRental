package com.bravo.gruppbravowigellkoncernencarrental.models.dto;

/**
 * <code>CarDto</code> - Car DTO entity
 * @authors Jessica
 * @version 0.0.1
 */

public class CarDto {

    private Long id;

    private String factory;
    private String model;
    private int costPerDay;
    private String registrationNumber;
    private boolean available;

    public CarDto() {
    }

    public CarDto(String factory, String model, int costPerDay, String registrationNumber, boolean available) {
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
