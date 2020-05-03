package io.swiggy.battleship.executor.impl;

import io.swiggy.battleship.enums.Instruction;
import io.swiggy.battleship.executor.Executor;
import io.swiggy.battleship.game.Board;
import io.swiggy.battleship.game.Game;

import java.util.Arrays;

public class NewGameExecutor extends Executor {


    public NewGameExecutor() {
        this.setValidInstructions(Arrays.asList(Instruction.PlaceShip, Instruction.SaveAndExit));
    }

    @Override
    public boolean validateInstruction(String instruction) {
        String[] arguments = instruction.split(" ");
        if (arguments.length != 2) {
            System.out.println("I need exactly two arguments and you know it!!");
            return false;
        }
        return true;
    }

    @Override
    public void executeInstruction(String instruction) throws Exception {
        setGameFinished(false);
        Game game =
                getGameManager().addNewGame(instruction.split(" ")[1]);
        setCurrentGame(game);

        String playerName = game.getTracker().getAttacker().getName();
        Board shipArrangenent = game.getTracker().getAttacker().getShipArrangement();
        Board attackTracker = game.getTracker().getAttacker().getAttackTracker();
        System.out.println("Hey " + playerName + " Your Ship Arrangement");
        shipArrangenent.showBoard();
        System.out.println("Hey " + playerName + " Your attack tracker");
        attackTracker.showBoard();
        System.out.println("Hey " + playerName + ", Make a move");

    }
}
