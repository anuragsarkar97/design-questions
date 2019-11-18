package io.gojek.parkinglot.service.impl;

import io.gojek.parkinglot.models.ParkingLot;
import io.gojek.parkinglot.models.enums.Color;
import io.gojek.parkinglot.models.enums.InstructionType;
import io.gojek.parkinglot.service.ParkingLotService;

import java.util.*;
import java.util.stream.Collectors;

import static io.gojek.parkinglot.costants.ParkingLotConstants.NOT_FOUND;

public class ParkingInformationService implements ParkingLotService<Void, String> {

    private static final Map<InstructionType, Runnable> commands = new HashMap<>();


    private void getSlotByRegistrationNumber(ParkingLot parkingLot, String... argument) {
        Boolean carFound = false;
        String registrationNumber = argument[1];
        Map<Color, Map<String, Integer>> colorSegmentMap = parkingLot.getColorSegmentMap();
        for (Map.Entry<Color, Map<String, Integer>> entry : colorSegmentMap.entrySet()) {
            Map<String, Integer> registrationNumerMap = entry.getValue();
            if (registrationNumerMap.containsKey(registrationNumber)) {
                System.out.println(registrationNumerMap.get(registrationNumber) + 1);
                carFound = true;
                break;
            }
        }
        if (!carFound) {
            System.out.println(NOT_FOUND);
        }
    }

    private void getSlotsByColor(ParkingLot parkingLot, String... argument) {
        Color color = Color.getColorByValue(argument[1]);
        Map<Color, Map<String, Integer>> colorSegmentMap = parkingLot.getColorSegmentMap();
        Map<String, Integer> cars = colorSegmentMap.get(color);
        Integer[] requiredSlots = cars.values().toArray(new Integer[cars.size()]);
        if (requiredSlots.length > 0) {
            List<String> slotsList = Arrays.stream(requiredSlots).map(x -> {
                return String.valueOf(x + 1);
            }).collect(Collectors.toList());
            System.out.println(String.join(", ", slotsList));

        } else {
            System.out.println("Not found");
        }
    }

    private void getRegistrationNumberByColor(ParkingLot parkingLot, String[] argument) {

        Color color = Color.getColorByValue(argument[1]);
        Map<Color, Map<String, Integer>> colorSegmentMap = parkingLot.getColorSegmentMap();
        Map<String, Integer> registrationSlotMap = colorSegmentMap.get(color);
        registrationSlotMap.keySet();
        if (registrationSlotMap.size() > 0) {
            System.out.println(String.join(", ", new ArrayList<String>(registrationSlotMap.keySet())));
        } else {
            System.out.println("Not Found");
        }
    }


    @Override
    public Void executeInstruction(ParkingLot parkingLot, String... argument) {
        String command = argument[0];
        InstructionType instructionType = InstructionType.getInstructionByValue(command);
        if (instructionType.equals(InstructionType.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR)) {
            getRegistrationNumberByColor(parkingLot, argument);
        } else if (instructionType.equals(InstructionType.SLOT_NUMBER_FOR_REGISTRATION_NUMBER)) {
            getSlotByRegistrationNumber(parkingLot, argument);
        } else if (instructionType.equals(InstructionType.SLOT_NUMBER_FOR_CARS_WITH_COLOR)) {
            getSlotsByColor(parkingLot, argument);
        }
        return null;
    }

}
