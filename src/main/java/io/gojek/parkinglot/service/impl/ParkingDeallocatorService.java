package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.Slot;
import io.gojek.parkinglot.models.enums.SlotStatus;
import io.gojek.parkinglot.service.ParkingLotService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingDeallocatorService implements ParkingLotService<Void, String> {

    private Logger logger = Logger.getLogger(ParkingDeallocatorService.class.getName());

    public Void executeInstruction(ParkingLot parkingLot, String... argument) {
        String slotNumber = argument[1];
        parkingLot
                .getSlots()
                .get(Integer.parseInt(slotNumber))
                .setStatus(SlotStatus.FREE);
        parkingLot
                .getSlots()
                .get(Integer.parseInt(slotNumber))
                .setVehicle(null);
        parkingLot.getColorSegmentMap().forEach((color, registrationSlotMap) -> {
            registrationSlotMap.forEach((registrationNumber, slotId) -> {
                if(Integer.parseInt(slotNumber) == slotId) {
                    registrationSlotMap.remove(registrationNumber);
                    logger.log(Level.INFO, "Slot number {} is free", slotId);
                }
            });
        });

        return null;
    }

    public Void executeInstruction(String... argument) {
        return null;
    }
}
