package io.swiggy.battleship.executor;

import io.swiggy.battleship.enums.Instruction;

import java.util.List;

public abstract class Executor {


    private List<Instruction> validInstructions;

    public abstract boolean validateInstruction();

    public abstract void executeInstruction();


    public List<Instruction> getValidInstructions() {
        return validInstructions;
    }

    public void setValidInstructions(List<Instruction> validInstructions) {
        this.validInstructions = validInstructions;
    }
}