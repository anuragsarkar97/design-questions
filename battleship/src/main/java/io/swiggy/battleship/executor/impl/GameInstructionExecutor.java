package io.swiggy.battleship.executor.impl;

import io.swiggy.battleship.enums.GameStatus;
import io.swiggy.battleship.enums.Instruction;
import io.swiggy.battleship.executor.Executor;
import io.swiggy.battleship.game.Board;
import io.swiggy.battleship.game.Game;
import io.swiggy.battleship.game.GameManager;

import java.util.Arrays;
import java.util.Map;

public class GameInstructionExecutor extends Executor {

    public GameInstructionExecutor() {
        this.setValidInstructions(Arrays.asList(Instruction.Attack, Instruction.SaveAndExit));
    }

    @Override
    public boolean validateInstruction(String instruction) throws Exception {
        String[] arguments = instruction.split(" ");
        if (arguments.length != 3) {
            return false;
        }
        try {
            if(getCurrentGame().getTracker().getDefender().getShipArrangement().isShipPlaced() && getCurrentGame().getTracker().getAttacker().getShipArrangement().isShipPlaced()) {
                return false;
            }
            int row = Integer.parseInt(arguments[1]);
            int col = Integer.parseInt(arguments[2]);

        } catch (NumberFormatException e) {
            throw new Exception("Ivalid argumets provided. input numbers");
        }
        return true;
    }


    @Override
    public void executeInstruction(String instruction) throws Exception {
        String[] arguments = instruction.split(" ");
        int row = Integer.parseInt(arguments[1]);
        int col = Integer.parseInt(arguments[2]);

        GameStatus gameStatus = getCurrentGame().startWar(row, col);
        if (gameStatus.equals(GameStatus.Finished)) {
            //Delete from map
            GameManager manager = getGameManager();
            Map<String, Game> gamesMap = manager.getGames();
            gamesMap.remove(getCurrentGame().getGameName());
            manager.setGames(gamesMap);
            setGameManager(manager);
            return;
        }
        Game game = getCurrentGame();
        String playerName = game.getTracker().getAttacker().getName();
        Board shipArrangement = game.getTracker().getAttacker().getShipArrangement();
        Board attackTracker = game.getTracker().getAttacker().getAttackTracker();
        System.out.println("Hey " + playerName + " Your Ship Arrangement");
        shipArrangement.showBoard();
        System.out.println("Hey " + playerName + " Your attack tracker");
        attackTracker.showBoard();
        System.out.println("Hey " + playerName + ", Make a move");
    }

}
