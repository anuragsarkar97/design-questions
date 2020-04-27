package io.swiggy.battleship.executor.impl;

import io.swiggy.battleship.enums.Alignment;
import io.swiggy.battleship.enums.Instruction;
import io.swiggy.battleship.enums.Ships;
import io.swiggy.battleship.executor.Executor;

import java.util.Arrays;

public class PlaceShipExecutor extends Executor {


    public PlaceShipExecutor() {

        this.setValidInstructions(Arrays.asList(Instruction.PlaceShip, Instruction.Attack, Instruction.SaveAndExit));
    }

    @Override
    public boolean validateInstruction(String instruction) throws Exception {
        // check if attacker placed
        String[] splitInstruction = instruction.split(" ");
        try {
            String whois = splitInstruction[1];
            Ships ship = Ships.valueOf(splitInstruction[2]);
            int x = Integer.parseInt(splitInstruction[3]);
            int y = Integer.parseInt(splitInstruction[4]);
            Alignment alignment = Alignment.valueOf(splitInstruction[5]);
            if ("ATTACKER".equals(whois)) {
                return getCurrentGame().getTracker().getAttacker().getShipArrangement().validateShipPlacement(ship, x, y, alignment)
                        && !getCurrentGame().getTracker().getAttacker().getShipArrangement().isShipPlaced();
            } else if ("DEFENDER".equals(whois)) {
                return getCurrentGame().getTracker().getDefender().getShipArrangement().validateShipPlacement(ship, x, y, alignment)
                        && !getCurrentGame().getTracker().getDefender().getShipArrangement().isShipPlaced();
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void executeInstruction(String instruction) throws Exception {

        String[] splitInstruction = instruction.split(" ");
        try {
            String whois = splitInstruction[1];
            Ships ship = Ships.valueOf(splitInstruction[2]);
            int x = Integer.parseInt(splitInstruction[3]);
            int y = Integer.parseInt(splitInstruction[4]);
            Alignment alignment = Alignment.valueOf(splitInstruction[5]);
            if ("ATTACKER".equals(whois)) {
                getCurrentGame().getTracker().getAttacker().getShipArrangement().addShip(ship, x, y, alignment);
            } else if ("DEFENDER".equals(whois)) {
                getCurrentGame().getTracker().getDefender().getShipArrangement().addShip(ship, x, y, alignment);
            } else {
                System.out.println("input parameter is not correct. Please Try again");
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }
}
