package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.costants.ParkingLotConstants;
import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.Slot;
import io.gojek.parkinglot.models.enums.SlotStatus;
import io.gojek.parkinglot.service.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

public class ParkingStatusService implements ParkingLotService<Void, String>{
    public Void executeInstruction(ParkingLot parkingLot, String... argument) {

        List<Integer> occupiedSlots = new ArrayList<Integer>();
        List<Slot> slotsList = parkingLot.getSlots();
        int index;
        for (index = 0; index < slotsList.size(); index++) {

            if (slotsList.get(index).getStatus().equals(SlotStatus.OCCUPIED)) {
                occupiedSlots.add(index);
            }
        }

        if (occupiedSlots.size() > 0) {
            System.out.println(String.join(" ",ParkingLotConstants.statusHeaders));
            for (Integer slotId: occupiedSlots) {
                Slot slotInfo = slotsList.get(slotId);
                System.out.println(slotId.toString() + " " +
                        slotInfo.getVehicle().getRegistrationNumber() + " " +
                        slotInfo.getVehicle().getColor().name());
            }
        }

        else {
            System.out.println("No vehicles found");
        }

        return null;
    }

    public Void executeInstruction(String... argument) {
        return null;
    }
}
