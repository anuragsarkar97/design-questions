package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.BoardType;
import io.swiggy.battleship.utils.FileUtil;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

public class Board {
    private int[][]  board;

    private boolean shipPlaced;

    public Board(BoardType boardType)  {
        this.board = new int[10][10];
        if (boardType.name().equals("Fleet")) {
            FileUtil util =  new FileUtil();
            this.board = util.getBoard();
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
        return shipPlaced;
    }

    public void setShipPlaced(boolean shipPlaced) {
        this.shipPlaced = shipPlaced;
    }

    public void showBoard(){
        System.out.println(Arrays.deepToString(this.board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println("-----------------------------");
    }
}
