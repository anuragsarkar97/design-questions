package io.gojek.parkinglot.validator.impl;

import io.gojek.parkinglot.ParkingLotApplication;
import io.gojek.parkinglot.validator.ValidationInterface;

import java.util.List;
import java.util.logging.Logger;

public class InstructionValidator implements ValidationInterface<String, Integer, Boolean> {


    public Integer validate(String instruction) {
        return null;
    }

    public Boolean validate(Integer argument, String... instructions) {
        switch (argument) {
            case 0:
                break;
            default:
                break;
        }
        return null;
    }
}
