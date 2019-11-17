package io.gojek.parkinglot.models.enums;


public enum InstructionType {

    CREATE("create_parking_lot"),
    PARK("park"),
    STATUS("status"),
    LEAVE("leave"),
    SLOT_NUMBER_FOR_CARS_WITH_COLOR("slot_numbers_for_cars_with_colour"),
    SLOT_NUMBER_FOR_REGISTRATION_NUMBER("slot_number_for_registration_number"),
    REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR("registration_numbers_for_cars_with_colour"),
    INVALID_INSTRUCTION("invalid_instruction"),
    EXIT("exit");

    private String value;


    InstructionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public static InstructionType getInstructionByValue(String command) {
        for (InstructionType instructionType : InstructionType.values()) {
            if (command.equals(instructionType.value)) {
                return instructionType;

            }
        }
        return InstructionType.INVALID_INSTRUCTION;
    }


    @Override
    public String toString() {
        return "IntructionType{" +
                "value='" + value + '\'' +
                '}';
    }
}


