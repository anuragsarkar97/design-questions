package io.swiggy.battleship.game;

import java.util.HashMap;
import java.util.Map;

public class GameManager {


    private Map<String, Game> games = new HashMap<String, Game>();

    public Game addNewGame(String gameName) throws Exception {
        if (games.containsKey(gameName)) {
            throw new Exception("Game already exists and you know it");
        }
        Game game = new Game();
        game.setGameName(gameName);
        games.put(gameName, game);
        return game;
    }

    public Map<String, Game> getGames() {
        return games;
    }

    public void setGames(Map<String, Game> games) {
        this.games = games;
    }
}
