package io.swiggy.battleship.executor.impl;

import io.swiggy.battleship.enums.Instruction;
import io.swiggy.battleship.executor.Executor;

import java.util.Arrays;

public class SaveGameExecutor extends Executor {

    public SaveGameExecutor() {
        this.setValidInstructions(Arrays.asList(Instruction.NewGame, Instruction.ResumeGame));
    }

    @Override
    public void executeInstruction() {

    }

    @Override
    public boolean validateInstruction() {
        return false;
    }
}
