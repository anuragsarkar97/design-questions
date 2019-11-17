package io.gojek.parkinglot.executor;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.enums.InstructionType;
import io.gojek.parkinglot.service.ParkingLotService;
import io.gojek.parkinglot.service.impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class InstructionExecutor implements ExecutorInterface<BufferedReader, Void> {

    ParkingLotService parkingInitializeService = new ParkingInitializeService();
    ParkingLotService parkingAllocatorService = new ParkingAllocatorService();
    ParkingLotService parkingStatusService = new ParkingStatusService();
    ParkingLotService parkingInformationService = new ParkingInformationService();
    ParkingLotService parkingDeallocatorService = new ParkingDeallocatorService();
    private  HashMap<InstructionType, ParkingLotService> serviceMap = new HashMap<InstructionType, ParkingLotService>();




    public Void execute(BufferedReader bufferReader) {
        Integer lineNumber = 0;
        serviceMap.put(InstructionType.PARK, parkingAllocatorService);
        serviceMap.put(InstructionType.STATUS, parkingStatusService);
        serviceMap.put(InstructionType.SLOT_NUMBER_FOR_CARS_WITH_COLOR, parkingInformationService);
        serviceMap.put(InstructionType.SLOT_NUMBER_FOR_REGISTRATION_NUMBER, parkingInformationService);
        serviceMap.put(InstructionType.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR, parkingInformationService);
        serviceMap.put(InstructionType.LEAVE, parkingDeallocatorService);
        serviceMap.put(InstructionType.CREATE, parkingInitializeService);



        try {
            String instruction;
            ParkingLot parkingLot = new ParkingLot();

            while ((instruction = bufferReader.readLine()) != null) {
                String[] parts = instruction.trim().split(" ");
                String command = parts[0];
                if (serviceMap.containsKey(InstructionType.getInstructionByValue(command))) {
                    serviceMap.get(InstructionType.getInstructionByValue(command)).executeInstruction(parkingLot, parts);
                }
                else if(InstructionType.getInstructionByValue(command).equals(InstructionType.EXIT)) {
                    break;
                }
                else {
                    System.out.println("Invalid Command found");
                }
            }
        } catch (IOException e) {

        }
        return null;
    }
}