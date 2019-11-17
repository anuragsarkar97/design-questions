package io.gojek.parkinglot.executor;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.enums.InstructionType;
import io.gojek.parkinglot.service.ParkingLotService;
import io.gojek.parkinglot.service.impl.*;

import java.io.BufferedReader;
import java.io.IOException;

public class InstructionExecutor implements ExecutorInterface<BufferedReader, Void> {

    ParkingLotService parkingInitializeService = new ParkingInitializeService();
    ParkingLotService parkingAllocatorService = new ParkingAllocatorService();
    ParkingLotService parkingStatusService = new ParkingStatusService();
    ParkingLotService parkingInformationService = new ParkingInformationService();
    ParkingLotService parkingDeallocatorService = new ParkingDeallocatorService();

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
                } else if (InstructionType.getInstructionByValue(command).equals(InstructionType.PARK)) {

                    parkingAllocatorService.executeInstruction(parkingLot, parts);

                } else if (InstructionType.getInstructionByValue(command).equals(InstructionType.STATUS)) {
                    parkingStatusService.executeInstruction(parkingLot, parts);
                } else if (InstructionType.getInstructionByValue(command).equals(InstructionType.SLOT_NUMBER_FOR_CARS_WITH_COLOR)) {
                    parkingInformationService.executeInstruction(parkingLot, parts);
                } else if (InstructionType.getInstructionByValue(command).equals(InstructionType.SLOT_NUMBER_FOR_REGISTRATION_NUMBER)) {
                    parkingInformationService.executeInstruction(parkingLot, parts);
                } else if (InstructionType.getInstructionByValue(command).equals(InstructionType.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR)) {
                    parkingInformationService.executeInstruction(parkingLot, parts);
                } else if (InstructionType.getInstructionByValue(command).equals(InstructionType.LEAVE)) {
                    parkingDeallocatorService.executeInstruction(parkingLot, parts);
                } else if(InstructionType.getInstructionByValue(command).equals(InstructionType.EXIT)) {
                    break;
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