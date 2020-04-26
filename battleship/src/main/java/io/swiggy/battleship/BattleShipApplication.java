package io.swiggy.battleship;

import io.swiggy.battleship.executor.GameLoopExecutor;

public class BattleShipApplication {

    public static void main(String... args) throws Exception {
//        GameLoop gameLoop = new GameLoop();
//        gameLoop.startGameLoop();
        GameLoopExecutor gameLoopExecutor = new GameLoopExecutor();
        gameLoopExecutor.executeLoop();
    }
}
