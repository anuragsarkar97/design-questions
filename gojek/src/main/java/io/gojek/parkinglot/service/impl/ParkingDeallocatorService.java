package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.enums.SlotStatus;
import io.gojek.parkinglot.service.ParkingLotService;

import java.util.Map;

import static io.gojek.parkinglot.costants.ParkingLotConstants.FREE_SPACE;
import static io.gojek.parkinglot.costants.ParkingLotConstants.SLOT_NUMBER;

public class ParkingDeallocatorService implements ParkingLotService<Void, String> {


    public Void executeInstruction(ParkingLot parkingLot, String... argument) {
        String slotNumber = argument[1];
        parkingLot
                .getSlots()
                .get(Integer.parseInt(slotNumber) - 1)
                .setStatus(SlotStatus.FREE);
        parkingLot
                .getSlots()
                .get(Integer.parseInt(slotNumber) - 1)
                .setVehicle(null);
        parkingLot.getColorSegmentMap().forEach((color, registrationSlotMap) -> {
            for (Map.Entry<String, Integer> entry : registrationSlotMap.entrySet()) {
                if (Integer.parseInt(slotNumber) - 1 == entry.getValue()) {
                    registrationSlotMap.remove(entry.getKey());
                    System.out.println(SLOT_NUMBER + (entry.getValue() + 1) + FREE_SPACE);
                }
            }
        });

        return null;
    }

}
