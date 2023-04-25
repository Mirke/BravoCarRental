package com.bravo.gruppbravowigellkoncernencarrental.entities;

import javax.persistence.*;

/**
 * <code>Car</code> - Car entity
 * @authors Karin
 * @version 0.0.1
 */

@Entity
public class Car {
    //Karins förslag
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long
    getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(length = 10, nullable = false)
    private String carSize;
    @Column(length = 10, nullable = false)
    private int costPerDay;
    @Column(nullable = false)
   private boolean available;

    public Car() {
    }

    public Car(Long id, String carSize, int costPerDay, boolean available) {
        this.id = id;
        this.carSize = carSize;
        this.costPerDay = costPerDay;
        this.available = available;
    }

    public Car(String carSize, int costPerDay, boolean available) {
        this.carSize = carSize;
        this.costPerDay = costPerDay;
        this.available = available;
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
