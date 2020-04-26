package io.swiggy.battleship.executor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecutorLoop {

    public void executorLoop() throws IOException {
        ExecutorFactory executorFactory = new ExecutorFactory();
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String instruction = reader.readLine();

            Executor executor = executorFactory.getExecutor(instruction);

            if (executor.validateInstruction(instruction)) {
                executor.executeInstruction(instruction);
                //update valid instructions
            }
        }
    }

}
