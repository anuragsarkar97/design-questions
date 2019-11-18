package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.Car;
import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.Slot;
import io.gojek.parkinglot.models.Vehicle;
import io.gojek.parkinglot.models.enums.Color;
import io.gojek.parkinglot.models.enums.SlotStatus;
import io.gojek.parkinglot.service.ParkingLotService;

import java.util.List;
import java.util.stream.Collectors;

import static io.gojek.parkinglot.costants.ParkingLotConstants.ALLOCATED_SPACE;

public class ParkingAllocatorService implements ParkingLotService<Void, String> {


    public Void executeInstruction(ParkingLot parkingLot, String... argument) {
        boolean slotFound = false;
        Color vehicleColor = Color.valueOf(argument[2]);
        String registrationNumber = argument[1];
        if(isPresent(parkingLot, registrationNumber)) {
            System.out.println("Vehicle with same registration number already Present! ");
            return null;
        }
        Car car = new Car(registrationNumber, vehicleColor);
        List<Slot> slots = parkingLot.getSlots();
        if (slots.size() == 0) {
            System.out.println("Please initialize parking lot");
        }
        for (int i = 0; i < slots.size(); i++) {
            Slot slot = slots.get(i);
            if (SlotStatus.FREE.equals(slot.getStatus())) {
                slot.setStatus(SlotStatus.OCCUPIED);
                slot.setVehicle(car);
                parkingLot.getColorSegmentMap().get(vehicleColor).put(registrationNumber, i);
                System.out.println(ALLOCATED_SPACE + (i + 1));
                slotFound = true;
                break;
            }
        }
        if (!slotFound) {
            System.out.println("Sorry, parking lot is full");
        }
        return null;
    }

    // check if same registration number already present
    private boolean isPresent(ParkingLot parkingLot,String registrationNumber) {
        try {
            return parkingLot.getSlots()
                    .parallelStream()
                    .filter(slot -> slot.getVehicle() != null)
                    .filter(slot -> slot
                            .getVehicle()
                            .getRegistrationNumber()
                            .equals(registrationNumber))
                    .count() >= 1;
        } catch (Exception e) {
            return false;
        }
    }
}
