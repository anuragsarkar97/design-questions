package io.gojek.parkinglot.validator.impl;

import io.gojek.parkinglot.ParkingLotApplication;
import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.enums.Color;
import io.gojek.parkinglot.models.enums.InstructionType;
import io.gojek.parkinglot.models.enums.SlotStatus;
import io.gojek.parkinglot.validator.ValidationInterface;

import java.util.List;
import java.util.logging.Logger;

public class InstructionValidator implements ValidationInterface<String, ParkingLot, Boolean> {


    public ParkingLot validate(String instruction) {
        return null;
    }

    public Boolean validate(ParkingLot parkingLot, String... instructions) {

        InstructionType command = InstructionType.getInstructionByValue(instructions[0]);

        switch (command) {
            case CREATE:
                if (instructions.length != 2 || !(isNumeric(instructions[1]))) {
                    System.out.println("Invalid Input");
                    return false;
                }
                if (Integer.valueOf(instructions[1]) == 0) {
                    System.out.println("Invalid size");
                    return false;
                }
                if (parkingLot.getSlots().size() != 0) {
                    System.out.println("Parking lot already created");
                    return false;
                }
                return true;

            case PARK:
                if (instructions.length != 3 || !(validColor(instructions[2]))) {
                    System.out.println("Invalid Input or color");
                    return false;
                }
                return true;
            case LEAVE:
                if (instructions.length != 2
                        || !(isNumeric(instructions[1]))) {
                    System.out.println("Invalid Input");
                    return false;
                }
                if (Integer.valueOf(instructions[1]) > parkingLot.getSlots().size() || Integer.valueOf(instructions[1]) < 1) {
                    System.out.println("Invalid Input");
                }
                if (parkingLot.getSlots().get(Integer.valueOf(instructions[1])-1).getStatus().equals(SlotStatus.FREE)) {
                    System.out.println("Slot is already free");
                }
                return true;
            case REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR:
                if (instructions.length != 2 || !(validColor(instructions[2]))) {
                    System.out.println("Invalid Input");
                    return false;
                }
                return true;
            case SLOT_NUMBER_FOR_CARS_WITH_COLOR:
                if (instructions.length != 2 || !(validColor(instructions[2]))) {
                    System.out.println("Invalid Input");
                    return false;
                }
                return true;

            default:
                return true;
        }
    }

    private boolean validColor(String instruction) {
        Color color = Color.getColorByValue(instruction);
        if (color.equals(Color.InvalidColor)) {
            return false;
        }
        return true;
    }

    private boolean isNumeric(String instruction) {
        try {
            Integer.parseInt(instruction);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
