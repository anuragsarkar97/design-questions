package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.service.ParkingLotService;

public class ParkingIntiliazeService implements ParkingLotService<ParkingLot, String> {
    public ParkingLot executeInstruction(String argument) {
        return null;
    }

    public ParkingLot executeInstruction(String... argument) {
        if (argument.length != 2) {
            //TODO :: Invalid instyriuction and throw error
            //        Try moving this to validation
        }
        Integer parkingLotSize = Integer.valueOf(argument[1]);
        ParkingLot parkingLot = new ParkingLot(parkingLotSize);
        return parkingLot;
    }

//    public Void executeInstruction(Integer instruction) {
//        new ParkingLot(instruction);
//        return null;
//    }

}
