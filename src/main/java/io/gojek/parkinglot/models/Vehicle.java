package io.gojek.parkinglot.models;

import io.gojek.parkinglot.models.enums.Color;

public abstract class Vehicle {

    private String registrationNuimber;

    private Color color;

    public String getRegistrationNuimber() {
        return registrationNuimber;
    }

    public void setRegistrationNuimber(String registrationNuimber) {
        this.registrationNuimber = registrationNuimber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}