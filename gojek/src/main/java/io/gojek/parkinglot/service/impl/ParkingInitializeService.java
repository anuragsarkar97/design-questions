package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.service.ParkingLotService;

import static io.gojek.parkinglot.costants.ParkingLotConstants.CREATED_PARKING_LOT;
import static io.gojek.parkinglot.costants.ParkingLotConstants.INVALID_COMMAND;

public class ParkingInitializeService implements ParkingLotService<Void, String> {


    public Void executeInstruction(ParkingLot parkingLot, String... argument) {
        if (argument.length != 2) {
            System.out.println(INVALID_COMMAND);
        }
        Integer parkingLotSize = Integer.valueOf(argument[1]);
        ParkingLot newParkingLot = new ParkingLot(parkingLotSize);
        parkingLot.setColorSegmentMap(newParkingLot.getColorSegmentMap());
        parkingLot.setSlots(newParkingLot.getSlots());
        System.out.println(CREATED_PARKING_LOT + parkingLot.getSlots().size() + " slots");
        return null;
    }
}
