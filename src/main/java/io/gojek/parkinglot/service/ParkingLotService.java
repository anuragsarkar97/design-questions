package io.gojek.parkinglot.service;

public interface ParkingLotService<A, B> {
    public A executeInstruction(B argument);

    public A executeInstruction(B... argument);
}
