package io.swiggy.battleship.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class FileUtil {
    public int[][] getBoard() {
        Random rand = new Random();
        String fileName = "ships/ship" + Integer.toString(rand.nextInt(6) + 1);
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        int[][] board = readFiles(file);
        return board;
    }

    private int[][] readFiles(File file)  {

        int[][] board = new int[10][10];
        try {
            Scanner scanner = new Scanner(file);
            for (int i = 0 ; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e ) {
            System.out.println(e.getMessage());
        }
        return board;
    }
}
