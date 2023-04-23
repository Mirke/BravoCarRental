package com.bravo.gruppbravowigellkoncernencarrental.models.dto;

public class CarDto {

    private Long id;
    private String carSize;
    private int costPerDay;
    private boolean available;

    public CarDto() {
    }

    public CarDto(String carSize, int costPerDay, boolean available) {
        this.carSize = carSize;
        this.costPerDay = costPerDay;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarSize() {
        return carSize;
    }

    public void setCarSize(String carSize) {
        this.carSize = carSize;
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

}
