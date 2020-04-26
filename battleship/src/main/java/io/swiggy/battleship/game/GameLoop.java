package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.GameChoice;
import io.swiggy.battleship.utils.InputUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLoop {

    public void startGameLoop() throws IOException {
        GameManager gameManager = new GameManager();
        while (true) {
            System.out.println("Please select from optino below \n" +
                    "1. Start a new game \n" +
                    "2. Resume one of the previous games");

            int option;
            try {
                 option = InputUtil.scanInputOption();
            } catch (Exception e) {
                continue;
            }
            switch (option) {
                case 1:
                    System.out.println("Staring a new game...");
                    gameManager.manageGames(GameChoice.StartOver);
                    break;
                case 2:
                    System.out.println("Staring one of the existing games...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }

    }

}
