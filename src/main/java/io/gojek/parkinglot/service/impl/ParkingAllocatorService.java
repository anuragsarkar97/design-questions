package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.Car;
import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.Slot;
import io.gojek.parkinglot.models.enums.Color;
import io.gojek.parkinglot.models.enums.SlotStatus;
import io.gojek.parkinglot.service.ParkingLotService;

import java.util.List;

public class ParkingAllocatorService implements ParkingLotService<Void, String> {


    public Void executeInstruction(ParkingLot parkingLot, String... argument) {

        Boolean slotFound = false;
        Color vehicleColor = Color.valueOf(argument[2]);
        String registrationNumber = argument[1];
        Car car = new Car(registrationNumber, vehicleColor);
        List<Slot> slots = parkingLot.getSlots();
        for (int i = 0; i < slots.size(); i++) {
            Slot slot = slots.get(i);
            if (SlotStatus.FREE.equals(slot.getStatus())) {
                slot.setStatus(SlotStatus.OCCUPIED);
                slot.setVehicle(car);
                parkingLot.getColorSegmentMap().get(vehicleColor).put(registrationNumber, i);
                System.out.println("Allocated slot number: " + (i + 1));
                slotFound = true;
                break;
            }
        }
        if (!slotFound) {
            System.out.println("Sorry, parking lot is full");
        }
        return null;
    }
}
