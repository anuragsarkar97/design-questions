package io.swiggy.battleship;

import io.swiggy.battleship.executor.GameLoopExecutor;
import io.swiggy.battleship.utils.FileUtil;

public class BattleShipApplication {

    public static void main(String... args) throws Exception {
        GameLoopExecutor gameLoopExecutor = new GameLoopExecutor();
        gameLoopExecutor.executeLoop();


    }
}
