package io.gojek.parkinglot;

import io.gojek.parkinglot.executor.ExecutorInterface;
import io.gojek.parkinglot.executor.FileExecutor;
import io.gojek.parkinglot.executor.InstructionExecutor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

import static io.gojek.parkinglot.costants.ParkingLotConstants.EXCEPTION_OCCURRED;
import static io.gojek.parkinglot.costants.ParkingLotConstants.FILE_NOT_FOUND;

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
            logger.log(Level.SEVERE, FILE_NOT_FOUND);
            System.out.println();

        } catch (Exception e) {
            logger.log(Level.SEVERE, EXCEPTION_OCCURRED, e.getMessage());
            //TODO: check and remove throws exception in instruction executor
        }

    }
}
