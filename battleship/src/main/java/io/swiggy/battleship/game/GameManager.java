package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.Choice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GameManager {


    Map<String, Game> games = new HashMap<String, Game>();


    public void manageGames(Choice choice) throws IOException {
        switch (choice.name()) {
            case "Resume":
                if (true) { // if list of games is empty
                    System.out.println("No games");
                }

                while (true) {//untill you get a vaild name) {
                    //Print Keys of map wait for buffer input

                    break;

                }
                String name = ""; // Get from buffer
                Game _game = games.get(name);
                _game.startWar();

            case "StartOver":
                String gameName;
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
                game.startWar();


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
