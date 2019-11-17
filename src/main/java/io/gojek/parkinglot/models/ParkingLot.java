package io.gojek.parkinglot.models;

import io.gojek.parkinglot.models.enums.SlotStatus;

import java.util.Arrays;
import java.util.List;

public class ParkingLot {

    private List<Slot> slots;

    public ParkingLot(int parkingLotSize) {
        Slot[] array = new Slot[parkingLotSize];
        Arrays.fill(array,0, parkingLotSize,new Slot());
        this.slots= Arrays.asList(array);
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
