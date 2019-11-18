package io.gojek.parkinglot.executor;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.enums.InstructionType;
import io.gojek.parkinglot.service.ParkingLotService;
import io.gojek.parkinglot.service.impl.*;
import io.gojek.parkinglot.validator.ValidationInterface;
import io.gojek.parkinglot.validator.impl.InstructionValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

import static io.gojek.parkinglot.costants.ParkingLotConstants.INVALID_COMMAND;

/**
 * validates each instruction to business logic and executes.
 */
public class InstructionExecutor implements ExecutorInterface<BufferedReader, Void> {

    ValidationInterface instructionValidator = new InstructionValidator();
    ParkingLotService parkingInitializeService = new ParkingInitializeService();
    ParkingLotService parkingAllocatorService = new ParkingAllocatorService();
    ParkingLotService parkingStatusService = new ParkingStatusService();
    ParkingLotService parkingInformationService = new ParkingInformationService();
    ParkingLotService parkingDeallocatorService = new ParkingDeallocatorService();
    private HashMap<InstructionType, ParkingLotService> serviceMap = new HashMap<InstructionType, ParkingLotService>();


    public Void execute(BufferedReader bufferReader) {
        Integer lineNumber = 0;


        try {
            String instruction;
            ParkingLot parkingLot = new ParkingLot();

            while ((instruction = bufferReader.readLine()) != null) {
                String[] parts = instruction.trim().split(" ");
                executeInstruction(parkingLot, parts);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Void executeInstruction(ParkingLot parkingLot, String... parts) {

        serviceMap.put(InstructionType.PARK, parkingAllocatorService);
        serviceMap.put(InstructionType.STATUS, parkingStatusService);
        serviceMap.put(InstructionType.SLOT_NUMBER_FOR_CARS_WITH_COLOR, parkingInformationService);
        serviceMap.put(InstructionType.SLOT_NUMBER_FOR_REGISTRATION_NUMBER, parkingInformationService);
        serviceMap.put(InstructionType.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR, parkingInformationService);
        serviceMap.put(InstructionType.LEAVE, parkingDeallocatorService);
        serviceMap.put(InstructionType.CREATE, parkingInitializeService);

        String command = parts[0];
        if (instructionValidator.validate(parkingLot, parts).equals(false)) {
        } else if (serviceMap.containsKey(InstructionType.getInstructionByValue(command))) {
            serviceMap.get(InstructionType.getInstructionByValue(command)).executeInstruction(parkingLot, parts);
        } else if (InstructionType.getInstructionByValue(command).equals(InstructionType.EXIT)) {
        } else {
            System.out.println(INVALID_COMMAND);
        }
        return null;

    }
}