package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.BoardType;

import java.util.Random;

public class Board {
    private int[][]  board;

    public Board(BoardType boardType) {
        this.board = new int[10][10];
        if (boardType.name().equals("fleet")) {
            //XXX: Ransomly filling 17 1's
            //TODO: Take input from buffer or file
            for (int i = 0 ; i< 17; i++) {
                Random rand = new Random();
                int row = rand.nextInt(10);
                int col = rand.nextInt(10);
                if (this.board[row][col] == 1 ){
                    i = i-1;
                    continue;
                }
                this.board[row][col] = 1;
            }
        }
    }

    public boolean validateAttack(int row, int col) {
        // check boundaries and duplicate attacks
        return true;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void showBoard(){
        // print this.board

    }
}
