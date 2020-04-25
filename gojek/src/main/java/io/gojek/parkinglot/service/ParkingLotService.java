package io.gojek.parkinglot.service;

import io.gojek.parkinglot.models.ParkingLot;

public interface ParkingLotService<A, B> {

    /**
     * @param parkingLot
     * @param argument
     * @return
     */
    public A executeInstruction(ParkingLot parkingLot, B... argument);

}
