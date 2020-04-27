package io.swiggy.battleship;

import io.swiggy.battleship.executor.GameLoopExecutor;

public class BattleShipApplication {

    public static void main(String... args) {
        GameLoopExecutor gameLoopExecutor = new GameLoopExecutor();
        gameLoopExecutor.executeLoop();
    }
}
