package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.service.ParkingLotService;

import java.util.logging.Logger;

public class ParkingInitializeService implements ParkingLotService<ParkingLot, String> {

    Logger logger = Logger.getLogger(ParkingInitializeService.class.getName());

    public ParkingLot executeInstruction(ParkingLot parkingLot, String... argument) {
        return null;
    }

    public ParkingLot executeInstruction(String... argument) {
        if (argument.length != 2) {
            //TODO :: Invalid instruction and throw error
            //        Try moving this to validation
        }
        Integer parkingLotSize = Integer.valueOf(argument[1]);
        return new ParkingLot(parkingLotSize);
    }

//    public Void executeInstruction(Integer instruction) {
//        new ParkingLot(instruction);
//        return null;
//    }

}
