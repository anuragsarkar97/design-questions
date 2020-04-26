package io.swiggy.battleship.game;

import io.swiggy.battleship.enums.BoardType;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private int[][]  board;

    public Board(BoardType boardType) {
        this.board = new int[10][10];
        if (boardType.name().equals("Fleet")) {
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

    public void showBoard(){
        System.out.println(Arrays.deepToString(this.board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println("-----------------------------");
    }
}
