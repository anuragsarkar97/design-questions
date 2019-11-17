package io.gojek.parkinglot;

import io.gojek.parkinglot.executor.ExecutorInterface;
import io.gojek.parkinglot.executor.FileExecutor;
import io.gojek.parkinglot.executor.InstructionExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ParkingLotApplication {

    public static void main(String... args) throws Exception {

        ExecutorInterface fileExecutor = new FileExecutor();
        ExecutorInterface instructionExecutor = new InstructionExecutor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        instructionExecutor.execute(reader);

        // TODO: take from args
//        String fileName = "../lot";
//        System.out.println(args[0]);
//
//        try {
//            BufferedReader bufferReader = (BufferedReader) fileExecutor.execute(fileName);
//            instructionExecutor.execute(bufferReader);
//        } catch (FileNotFoundException e) {
//            System.out.println();
//
//        } catch (Exception e) {
//        }

    }
}
