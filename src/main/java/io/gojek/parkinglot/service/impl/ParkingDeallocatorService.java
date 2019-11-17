package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.Slot;
import io.gojek.parkinglot.models.enums.Color;
import io.gojek.parkinglot.models.enums.SlotStatus;
import io.gojek.parkinglot.service.ParkingLotService;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingDeallocatorService implements ParkingLotService<Void, String> {

    private Logger logger = Logger.getLogger(ParkingDeallocatorService.class.getName());

    public Void executeInstruction(ParkingLot parkingLot, String... argument) {
        String slotNumber = argument[1];
        parkingLot
                .getSlots()
                .get(Integer.parseInt(slotNumber)-1)
                .setStatus(SlotStatus.FREE);
        parkingLot
                .getSlots()
                .get(Integer.parseInt(slotNumber)-1)
                .setVehicle(null);
        parkingLot.getColorSegmentMap().forEach((color, registrationSlotMap) -> {
            for(Map.Entry<String, Integer> entry : registrationSlotMap.entrySet()) {
                if(Integer.parseInt(slotNumber)-1 == entry.getValue()) {
                    registrationSlotMap.remove(entry.getKey());
                    logger.log(Level.INFO, "Slot number " + (entry.getValue()+1)+  " is free" );
                }
            }
        });

            return null;
    }

    public Void executeInstruction(String... argument) {
        return null;
    }
}
