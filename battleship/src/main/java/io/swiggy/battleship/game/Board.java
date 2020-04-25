package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.BoardType;

public class Board {
    private int[][]  board;


    //  enum custructor

    public Board(BoardType boardType) {

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
