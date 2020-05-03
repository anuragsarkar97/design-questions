package io.swiggy.battleship.executor.impl;

import io.swiggy.battleship.enums.Instruction;
import io.swiggy.battleship.executor.Executor;

import java.util.Arrays;

public class SaveGameExecutor extends Executor {

    public SaveGameExecutor() {
        this.setValidInstructions(Arrays.asList(Instruction.NewGame, Instruction.ResumeGame));
    }

    @Override
    public boolean validateInstruction(String instruction) throws Exception {
         String[] arguments = instruction.split(" ");
         if (arguments.length != 1) {
             return false;
         }
         return true;
    }

    @Override
    public void executeInstruction(String instruction) throws Exception {

    }
}
