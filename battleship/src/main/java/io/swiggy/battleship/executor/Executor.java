package io.swiggy.battleship.executor;

import io.swiggy.battleship.enums.Instruction;
import io.swiggy.battleship.game.Game;
import io.swiggy.battleship.game.GameManager;

import java.util.List;

public abstract class Executor {


    private List<Instruction> validInstructions;

    private static Game currentGame;

    private static GameManager gameManager = new GameManager();

    public abstract boolean validateInstruction(String inctruction) throws Exception;

    public abstract void executeInstruction(String instruction) throws Exception;


    public List<Instruction> getValidInstructions() {
        return validInstructions;
    }

    public void setValidInstructions(List<Instruction> validInstructions) {
        this.validInstructions = validInstructions;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Executor.currentGame = currentGame;
    }

    public static GameManager getGameManager() {
        return gameManager;
    }

    public static void setGameManager(GameManager gameManager) {
        Executor.gameManager = gameManager;
    }
}
