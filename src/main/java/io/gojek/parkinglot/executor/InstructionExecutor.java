package io.gojek.parkinglot.executor;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.enums.InstructionType;
import io.gojek.parkinglot.service.ParkingLotService;
import io.gojek.parkinglot.service.impl.ParkingInitializeService;

import java.io.BufferedReader;
import java.io.IOException;

public class InstructionExecutor implements ExecutorInterface<BufferedReader,Void> {

    ParkingLotService parkingInitializeService = new ParkingInitializeService();

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

                    if (InstructionType.getInstructionByValue(command).equals(InstructionType.STATUS)) {

                    }
                    // TODO:: Write other else if nd throw  exception
                    else {
                        // TODO: Throw exception
                    }





            }
        } catch (IOException e) {

        }
        return null;
    }
}