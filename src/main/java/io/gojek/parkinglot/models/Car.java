package io.gojek.parkinglot.models;

import io.gojek.parkinglot.models.enums.Color;

public class Car extends Vehicle{

    public Car(String registrationNumber, Color color) {
        super(registrationNumber, color);
    }
}
