package io.swiggy.battleship.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLoop {

    public void startGameLoop() throws IOException {
        while (true) {
            System.out.println("Please select from optino below \n" +
                    "1. Start a new game \n" +
                    "2. Resume one of the previous games");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int option;
            try {
                 option = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                continue;
            }
            switch (option) {
                case 1:
                    System.out.println("Staring a new game...");
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
