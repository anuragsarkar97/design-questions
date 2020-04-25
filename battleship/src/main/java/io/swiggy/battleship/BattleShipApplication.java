package io.swiggy.battleship;

import io.swiggy.battleship.game.Game;
import io.swiggy.battleship.game.GameLoop;

public class BattleShipApplication {

    public static void main(String... args) throws Exception {
        GameLoop gameLoop = new GameLoop();
        gameLoop.startGameLoop();
    }
}
