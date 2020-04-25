package io.swiggy.battleship.game;

import io.swiggy.battleship.players.Player;

public class Game {
     Player attacker = new Player("Dilip");
     Player defender = new Player("Anurag");
     Player winner = null;

     public void startWar() {
         while (winner == null) {
             int row = -1;
             int col = -1;
             // XXX: write a private func to choose saveQuit/attack
             while ( !attacker.getAttackTracker().validateAttack(row, col)) {
                 System.out.println("Hey " +
                         attacker.getName() + " enter position to attack");
                 // Keep  getting row col from buffer and update them

             }
             attacker.attack(row, col, defender.sufferAttack(row, col));
             if (defender.getPoints() == 0) {
                 winner = attacker;
             }
             // swap turns

         }
         System.out.println("Winner is " + winner.getName());
     }

     private void swapTurns(Player attacker, Player defender) {
         // i guess this type of swap will not work
         Player temp = defender;
         defender = attacker;
         attacker = temp;
     }

}
