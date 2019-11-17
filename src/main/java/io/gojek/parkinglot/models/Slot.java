package io.gojek.parkinglot.models;


import io.gojek.parkinglot.models.enums.SlotStatus;
import io.gojek.parkinglot.models.enums.SlotType;

public  class Slot {

    private SlotStatus status;

    private SlotType slotType;

    public Slot() {
        this.status = SlotStatus.FREE;
        this.slotType = SlotType.FOUR_WHEELER;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }
}

