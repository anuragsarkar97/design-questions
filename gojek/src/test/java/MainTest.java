import io.gojek.parkinglot.executor.InstructionExecutor;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;


public class MainTest {

    private InstructionExecutor executor = new InstructionExecutor();

    @Test
    public void Test() {
        String[] args = {"create_parking_lot 6", // create parking
                "park KA-01-HH-9999 White", // add a ca
                "park KA-01-HH-1234 White", // add another car
                "park KA-01-HH-9999 White", // add same car (produce error)
                "park KA-01-BB-0001 Black", // add one more
                "park KA-01-HH-7777 Red", // and moe
                "park KA-01-HH-2701 Blue", // and a blue car
                "registration_numbers_for_cars_with_colour White", // get all white cars
                "park KA-01-HH-3141 Black", // add a black car because why not
                "leave 4", // remove a car
                "status", // check status
                "park KA-01-P-333 White", // add
                "park KA-01-P-333 White", // add
                "park DL-12-AA-9999 White", // add
                "registration_numbers_for_cars_with_colour White", // get
                "slot_numbers_for_cars_with_colour White", // get
                "slot_number_for_registration_number KA-01-HH-3141", // get slots
                "slot_number_for_registration_number MH-04-AY-1111" // get slots
        };
        for (String arg : args) {
            executor.execute(helper(arg));
        }
    }

    public BufferedReader helper(String input) {
        Reader inputString = new StringReader(input);
        return new BufferedReader(inputString);
    }
}
