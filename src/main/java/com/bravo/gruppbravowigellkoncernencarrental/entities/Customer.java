package com.bravo.gruppbravowigellkoncernencarrental.entities;

import com.bravo.gruppbravowigellkoncernencarrental.models.dto.CustomerDto;

import javax.persistence.*;

/**
 * <code>Customer</code> - Customer entity
 * @authors Karin
 * @version 0.0.1
 */

@Entity
public class Customer {
    //Karins förslag
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public CustomerDto getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(length = 30, nullable = false)
    private String firstName;
    @Column(length = 30, nullable = false)
    private String lastName;
    @Column(length = 30, nullable = false)
    private String streetAddress;
    @Column(length = 6, nullable = false)
    private int postalCode;
    @Column(length = 30, nullable = false)
    private String city;
    @Column(length = 45, nullable = false)
    private String email;
    @Column(length = 12, nullable = false)
    private int phone;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String streetAddress, int postalCode, String city, String email, int phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
