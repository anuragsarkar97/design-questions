package io.gojek.parkinglot.service;

import io.gojek.parkinglot.models.ParkingLot;

public interface ParkingLotService<A, B> {

    public A executeInstruction(ParkingLot parkingLot, B... argument);

    public A executeInstruction(B... argument);
}
