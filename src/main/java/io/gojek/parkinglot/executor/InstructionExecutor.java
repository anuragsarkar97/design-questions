package io.gojek.parkinglot.executor;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.enums.InstructionType;
import io.gojek.parkinglot.service.ParkingLotService;
import io.gojek.parkinglot.service.impl.ParkingAllocatorService;
import io.gojek.parkinglot.service.impl.ParkingInitializeService;
import io.gojek.parkinglot.service.impl.ParkingStatusService;

import java.io.BufferedReader;
import java.io.IOException;

public class InstructionExecutor implements ExecutorInterface<BufferedReader,Void> {

    ParkingLotService parkingInitializeService = new ParkingInitializeService();
    ParkingLotService parkingAllocatorService = new ParkingAllocatorService();
    ParkingLotService parkingStatusService = new ParkingStatusService();

    ParkingLot parkingLot = null;

    public Void execute(BufferedReader bufferReader) {
        Integer lineNumber = 0;
        try {
            String instruction;
            while ((instruction = bufferReader.readLine()) != null) {
                String[] parts = instruction.trim().split(" ");
                String command = parts[0];
                    if (InstructionType.getInstructionByValue(command).equals(InstructionType.CREATE)) {
                         parkingLot = (ParkingLot) parkingInitializeService.executeInstruction(parts);
                    }
                    else if (InstructionType.getInstructionByValue(command).equals(InstructionType.PARK)) {

                        parkingAllocatorService.executeInstruction(parkingLot, parts);

                    }
                    else if (InstructionType.getInstructionByValue(command).equals(InstructionType.STATUS)) {
                        parkingStatusService.executeInstruction(parkingLot, parts);
                    }
                    // TODO:: Write other else if nd throw  exception
                    else {
                        System.out.println("Invalid Command found");
                        // TODO: Throw exceptoip

                    }
            }
        } catch (IOException e) {

        }
        return null;
    }
}