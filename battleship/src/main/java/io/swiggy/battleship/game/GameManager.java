package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.Choice;

import java.util.HashMap;
import java.util.Map;

public class GameManager {


    Map<String, Game> games = new HashMap<String, Game>();


    public void manageGames(Choice choice) {
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
                while (true) { // untill you get valid {

                    break;
                }

                Game game= new Game();
                //insert into map with name
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
