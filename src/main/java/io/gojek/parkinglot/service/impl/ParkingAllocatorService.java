package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.Car;
import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.Slot;
import io.gojek.parkinglot.models.enums.Color;
import io.gojek.parkinglot.models.enums.SlotStatus;
import io.gojek.parkinglot.service.ParkingLotService;
import io.gojek.parkinglot.validator.impl.InstructionValidator;

import java.util.logging.Logger;

public class ParkingAllocatorService implements ParkingLotService<Void, String> {

    Logger logger = Logger.getLogger(ParkingAllocatorService.class.getName());

    public Void executeInstruction(ParkingLot parkingLot, String... argument) {
        Car car = new Car(argument[1], Color.valueOf(argument[2]));
        for(Slot slot : parkingLot.getSlots()) {
            if (SlotStatus.FREE.equals(slot.getStatus())) {

            }
        }
        return null;
    }

    public Void executeInstruction(String... argument) {
        return null;
    }
}
