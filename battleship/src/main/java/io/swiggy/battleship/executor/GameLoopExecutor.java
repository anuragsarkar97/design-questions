package io.swiggy.battleship.executor;

import io.swiggy.battleship.enums.Instruction;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameLoopExecutor {

    public void executeLoop() {
        ExecutorFactory executorFactory = new ExecutorFactory();
        Executor executor;

        List<Instruction> validInstructions = Collections.singletonList(Instruction.NewGame);
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
                    validInstructions = executor.getValidInstructions();
                    if (Executor.isGameFinished()) {
                        validInstructions = Arrays.asList(Instruction.NewGame, Instruction.ResumeGame);
                        Executor.setGameFinished(false);
                    }
                } else {
                    System.out.println("Instruction not valid ");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

}
