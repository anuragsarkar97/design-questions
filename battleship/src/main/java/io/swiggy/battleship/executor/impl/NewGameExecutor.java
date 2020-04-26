package io.swiggy.battleship.executor.impl;

import io.swiggy.battleship.enums.Instruction;
import io.swiggy.battleship.executor.Executor;

import java.util.Arrays;

public class NewGameExecutor extends Executor {

    public NewGameExecutor() {
        this.setValidInstructions(Arrays.asList(Instruction.Attack, Instruction.SaveAndExit));
    }
    @Override
    public boolean validateInstruction(String instruction) {
        return false;
    }

    @Override
    public void executeInstruction(String instruction) {

    }
}
