package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.service.ParkingLotService;
import io.gojek.parkinglot.validator.impl.InstructionValidator;

import java.util.logging.Logger;

public class ParkingAllocatorService implements ParkingLotService<Void, String> {

    Logger logger = Logger.getLogger(ParkingAllocatorService.class.getName());

    public Void executeInstruction(ParkingLot parkingLot, String... argument) {
        return null;
    }

    public Void executeInstruction(String... argument) {
        return null;
    }
}
