package io.swiggy.battleship.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
    public static int  scanInputOption() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int option;
        try {
            option = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println("Invalid input");
            throw e;
        }
        return option;
    }
}
