package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.GameStatus;
import io.swiggy.battleship.players.Player;
import io.swiggy.battleship.players.PlayerTracker;
import io.swiggy.battleship.utils.InputUtil;

public class Game {
     Player playerA = new Player("Dilip");
     Player playerB = new Player("Anurag");
     Player winner = null;
     PlayerTracker tracker = new PlayerTracker(playerA, playerB);

     public GameStatus startWar() {
         while (winner == null) {
             int row = -1;
             int col = -1;
             // XXX: write a private func to choose saveQuit/attack
             if (saveAndExit()) {
                 return GameStatus.SaveAndExit;
             }
             while ( !tracker.getAttacker().getAttackTracker().validateAttack(row, col)) {
                 System.out.println("Hey " +
                         tracker.getAttacker().getName() + " enter position to attack");
                 // TODO: Print attack tracker
                 // Keep  getting row col from buffer and update them
                 System.out.println("Here is your board");
                 tracker.getAttacker().getShipArrangement().showBoard();

                 System.out.println("Here is your tracker");
                 tracker.getAttacker().getAttackTracker().showBoard();
                 try {
                     System.out.println("Select row");
                     row = InputUtil.scanInputOption();
                     System.out.println("Select column");
                     col = InputUtil.scanInputOption();
                 } catch (Exception e) {
                     System.out.println("Dont be silly");
                     continue;
                 }
             }
             boolean defenderStatus = tracker.getDefender().sufferAttack(row, col);
             tracker.getAttacker().attack(row, col, defenderStatus);
             if (tracker.getDefender().getPoints() == 0) {
                 winner = tracker.getAttacker();
                 break;
             }

             if (defenderStatus) {
                 System.out.println("Checkout your tracker, cool isn't it");
             } else {
                 System.out.println("Aim properly you silly wanker");
             }
             tracker.getAttacker().getAttackTracker().showBoard();
             tracker.swap();

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


}
