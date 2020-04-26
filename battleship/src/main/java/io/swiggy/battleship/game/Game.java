package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.GameStatus;
import io.swiggy.battleship.players.Player;
import io.swiggy.battleship.players.PlayerTracker;
import io.swiggy.battleship.utils.InputUtil;

public class Game {
     private String gameName;
     private Player playerA = new Player("Dilip");
     private Player playerB = new Player("Anurag");
     private Player winner = null;
     private PlayerTracker tracker = new PlayerTracker(playerA, playerB);

     public GameStatus startWar(int row, int col) throws Exception {
         if (!tracker.getAttacker().getAttackTracker().validateAttack(row, col)) {
             throw new Exception("Not a valid attck position");
         }
         boolean defenderStatus = tracker.getDefender().sufferAttack(row, col);
         tracker.getAttacker().attack(row, col, defenderStatus);
         if (tracker.getDefender().getPoints() == 0) {
            System.out.println("Winner is " + tracker.getAttacker().getName());
            return GameStatus.Finished;
         }
         if (defenderStatus) {
             System.out.println("Checkout your tracker, cool isn't it");
         } else {
             System.out.println("Aim properly you silly wanker");
         }
         tracker.getAttacker().getAttackTracker().showBoard();
         tracker.swap();
         return GameStatus.ToBeContinued;
     }
     public PlayerTracker getTracker() {
        return tracker;
     }

     public String getGameName() {
        return gameName;
     }

     public void setGameName(String gameName) {
        this.gameName = gameName;
     }
}
