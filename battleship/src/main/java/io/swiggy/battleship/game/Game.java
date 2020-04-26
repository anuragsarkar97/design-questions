package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.GameStatus;
import io.swiggy.battleship.players.Player;
import io.swiggy.battleship.utils.InputUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game {
     Player attacker = new Player("Dilip");
     Player defender = new Player("Anurag");
     Player winner = null;

     public GameStatus startWar() {
         while (winner == null) {
             int row = -1;
             int col = -1;
             // XXX: write a private func to choose saveQuit/attack
             if (saveAndExit()) {
                 return GameStatus.SaveAndExit;
             }
             while ( !attacker.getAttackTracker().validateAttack(row, col)) {
                 System.out.println("Hey " +
                         attacker.getName() + " enter position to attack");
                 // TODO: Print attack tracker
                 // Keep  getting row col from buffer and update them
                 try {
                     System.out.println("Select row");
                     row = InputUtil.scanInputOption();
                     System.out.println("Select column");
                     col = InputUtil.scanInputOption();
                 } catch (Exception e) {
                     continue;
                 }
             }
             attacker.attack(row, col, defender.sufferAttack(row, col));
             if (defender.getPoints() == 0) {
                 winner = attacker;
             }
             // swap turns

         }
         System.out.println("Winner is " + winner.getName());
         return GameStatus.Finished;
     }

    private boolean saveAndExit() {
         while (true) {
             System.out.println("Select an option\n" +
                     "1: Save And Exit\n" +
                     "2: Attack");
             int option;
             try {
                 option = InputUtil.scanInputOption();
             } catch (Exception e) {
                 continue;
             }
             switch (option) {
                 case 1:
                     return true;
                 case 2:
                     return false;
                 case 3:
                     System.out.println("Option unavailable");
                     continue;
             }

         }
    }

    private void swapTurns(Player attacker, Player defender) {
         // i guess this type of swap will not work
         Player temp = defender;
         defender = attacker;
         attacker = temp;
     }

}
