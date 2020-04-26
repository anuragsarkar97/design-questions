package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.GameChoice;
import io.swiggy.battleship.enums.GameStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class GameManager {


    Map<String, Game> games = new HashMap<String, Game>();


    public void manageGames(GameChoice choice) throws IOException {
        String gameName;
        switch (choice.name()) {
            case "Resume":
                if (games.size() == 0) {
                    System.out.println("Dont be silly. Start a new game!!");
                    return;
                }
                while (true) {
                    System.out.println("Enter on of the games below");
                    System.out.println(StringUtils.join(games.keySet(), "\n"));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                     gameName = reader.readLine();
                    if (!games.containsKey(gameName)) {
                        System.out.println("Dont be silly!!!");
                        continue;
                    }

                    break;

                }
                Game _game = games.get(gameName);
                _game.startWar();

            case "StartOver":
                while (true) {
                    System.out.println("Enter a name for your game");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    gameName = reader.readLine();
                    if (games.containsKey(gameName)) {
                        System.out.println("Dont act smart, choose a different name");
                        continue;
                    }
                    break;
                }

                Game game = new Game();
                games.put(gameName, game);
                GameStatus status = game.startWar();
                if (status.equals(GameStatus.Finished)) {
                    games.remove(gameName);
                    System.out.println("test");
                }
                System.out.println("test");
            default:
                break;
        }

    }

    public void endGame(String gameName) {
        //delete from map
    }

    public void pauseGame(String gameName) {
        //add to map
    }
}
