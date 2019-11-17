package io.gojek.parkinglot;

import io.gojek.parkinglot.executor.ExecutorInterface;
import io.gojek.parkinglot.executor.FileExecutor;
import io.gojek.parkinglot.executor.InstructionExecutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

public class ParkingLotApplication {

    public static void main(String... args) {

        Logger logger = Logger.getLogger(ParkingLotApplication.class.getName());

        // TODO: take from args
        String fileName = "../lot";

        ExecutorInterface fileExecutor = new FileExecutor();
        ExecutorInterface instructionExecutor = new InstructionExecutor();

        try {
            BufferedReader bufferReader = (BufferedReader) fileExecutor.execute(fileName);
            instructionExecutor.execute(bufferReader);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (Exception e) {
            System.out.println("exception");
            //TODO: check and remove throws exception in instruction executor
        }

    }
}
