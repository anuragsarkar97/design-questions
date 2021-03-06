package io.gojek.parkinglot.models;

import io.gojek.parkinglot.models.enums.Color;

public abstract class Vehicle {

    private String registrationNumber;

    private Color color;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vehicle(String registrationNumber, Color color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
}