package io.swiggy.battleship.executor.impl;

import io.swiggy.battleship.enums.Instruction;
import io.swiggy.battleship.executor.Executor;

import java.util.Arrays;

public class PlaceShipExecutor extends Executor {


    public PlaceShipExecutor( ) {
        this.setValidInstructions(Arrays.asList(Instruction.PlaceShip));
    }
    @Override
    public boolean validateInstruction(String inctruction) throws Exception {
        // check if attacker placed
        return false;
    }

    @Override
    public void executeInstruction(String instruction) throws Exception {

        // Place Ship Attacker S1 2 2 7 2
        // Place Ship Defender S2 3 3 8 3

        // check if defender placed
        this.setValidInstructions(Arrays.asList(Instruction.Attack, Instruction.SaveAndExit));
    }
}
