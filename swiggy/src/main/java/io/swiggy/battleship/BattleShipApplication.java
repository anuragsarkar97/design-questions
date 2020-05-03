package io.swiggy.battleship;

import io.swiggy.battleship.executor.GameLoopExecutor;

public class BattleShipApplication {

    // IMPORTANT : Please read the readme before starting the game

    public static void main(String... args) {
        GameLoopExecutor gameLoopExecutor = new GameLoopExecutor();
        gameLoopExecutor.executeLoop();
    }
}
