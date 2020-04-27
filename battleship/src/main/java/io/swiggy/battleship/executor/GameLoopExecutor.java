package io.swiggy.battleship.executor;

import io.swiggy.battleship.enums.Instruction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class GameLoopExecutor {

    public void executeLoop() {
        ExecutorFactory executorFactory = new ExecutorFactory();

        // This line is hack to get valid instructions initially
        Executor executor ;

        List<Instruction> validInstructions = Arrays.asList(Instruction.NewGame);
        while (true) {
            System.out.println("Choose one of the actions below");
            validInstructions.forEach(System.out::println);
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String instructionString = reader.readLine();


                Instruction instruction = Instruction.valueOf(instructionString.split(" ")[0]);
                if (!validInstructions.contains(instruction)) {
                    System.out.println("Invalid State for instruction");
                    continue;
                }
                executor = executorFactory.getExecutor(instruction);

                if (executor.validateInstruction(instructionString)) {
                    executor.executeInstruction(instructionString);
                } else {
                    continue;
                }
                validInstructions = executor.getValidInstructions();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

}
