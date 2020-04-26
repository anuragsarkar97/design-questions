package io.swiggy.battleship.players;

import io.swiggy.battleship.game.Board;

import static io.swiggy.battleship.enums.BoardType.Fleet;
import static io.swiggy.battleship.enums.BoardType.Tracker;

public  class Player {

    String name;
    Board shipArrangement = new Board(Fleet);
    Board attackTracker = new Board(Tracker);
    int points = 17;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, Board shipArrangement, Board attackTracker, int points) {
        this.name = name;
        this.shipArrangement = shipArrangement;
        this.attackTracker = attackTracker;
        this.points = points;

    }

    public Player clone() {
        return new Player(this.name, 
        this.shipArrangement, 
        this.attackTracker, 
        this.points);
    }
    // Mark the attcked positions in your map
    public  void attack(int row, int col, boolean attacked) {
        int[][] trackerBoard = attackTracker.getBoard();
        if (attacked) {
            trackerBoard[row][col] = 1;
        } else{
            trackerBoard[row][col] = -1;
        }
        attackTracker.setBoard(trackerBoard);
    };

    // Return if the position is attackable by opponent
    // ( not an already attacked position)

    // update ship arrangement
    // return true if there is a ship in position (row, col)
    // reduce points by one if suffered
    public  boolean sufferAttack(int row, int col) {
        int[][] board = shipArrangement.getBoard();
        if (board[row][col] == 0) {
            return false;
        }
        points -= 1;
        board[row][col] = -1;
        shipArrangement.setBoard(board);
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getShipArrangement() {
        return shipArrangement;
    }

    public void setShipArrangement(Board shipArrangement) {
        this.shipArrangement = shipArrangement;
    }

    public Board getAttackTracker() {
        return attackTracker;
    }

    public void setAttackTracker(Board attackTracker) {
        this.attackTracker = attackTracker;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
