package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.Alignment;
import io.swiggy.battleship.enums.Ships;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private int[][] board;

    private int boardSize = 10;

    private Map<Ships, Boolean> shipPlaced;

    static Map<Ships, Integer> availableShips = new HashMap<>();

    static {
        availableShips.put(Ships.Battleship, 4);
        availableShips.put(Ships.Cruiser, 3);
        availableShips.put(Ships.Carrier, 5);
        availableShips.put(Ships.Submarine, 3);
        availableShips.put(Ships.Destroyer, 2);
    }

    public Board() {
        this.board = new int[this.boardSize][this.boardSize];
        this.shipPlaced = new HashMap<>();
    }

    public int getTotalPoints() {
        int count = 0;
        for (Ships p : availableShips.keySet()) {
            count += availableShips.get(p);
        }
        return count;
    }

    public void addShip(Ships ship, int XPos, int YPos, Alignment alignment) {
        Integer sizeOfShip = availableShips.get(ship);
        if (Alignment.Horizontal.equals(alignment)) {
            for (int i = YPos; i < YPos + sizeOfShip; i++) {
                this.board[XPos][i] = 1;
            }
        } else if (Alignment.Vertical.equals(alignment)) {
            for (int i = XPos; i < XPos + sizeOfShip; i++) {
                this.board[i][YPos] = 1;
            }
        }
        this.shipPlaced.put(ship, true);
        this.showBoard();
    }

    public boolean validateShipPlacement(Ships ship, int XPos, int YPos, Alignment alignment) {
        if (this.shipPlaced.get(ship) != null) {
            return false;
        }
        Integer sizeOfShip = availableShips.get(ship);
        if (Alignment.Horizontal.equals(alignment)) {
            for (int i = YPos; i < YPos + sizeOfShip; i++) {
                if (this.board[XPos][i] == 1) return false;
            }
            return XPos >= 0 && XPos < this.boardSize && YPos >= 0 && YPos + sizeOfShip-1 < this.boardSize;
        } else if (Alignment.Vertical.equals(alignment)) {
            for (int i = XPos; i < XPos + sizeOfShip; i++) {
                if (this.board[i][YPos] == 1) return false;
            }
            return XPos >= 0 && XPos + sizeOfShip-1 < this.boardSize && YPos >= 0 && YPos < this.boardSize;
        } else {
            return false;
        }
    }

    //Note: For attck tracker 1: successful attack -1: failed attck 0: free to attack
    public boolean validateAttack(int row, int col) {
        // check boundaries and duplicate attacks
        if (row >= 0 && row < 10 && col >= 0 && col < 10 && board[row][col] == 0) {
            return true;
        }
        System.out.println("The position is either out of board or already attacked");
        return false;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public boolean isShipPlaced() {
        return this.shipPlaced.size() == availableShips.size();
    }

    public void showBoard() {
        System.out.println(Arrays.deepToString(this.board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println("-----------------------------");
    }
}
