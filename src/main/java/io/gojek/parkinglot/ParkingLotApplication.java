package io.gojek.parkinglot;

import io.gojek.parkinglot.executor.ExecutorInterface;
import io.gojek.parkinglot.executor.FileExecutor;
import io.gojek.parkinglot.executor.InstructionExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static io.gojek.parkinglot.costants.ParkingLotConstants.FILE_NOT_FOUND;

public class ParkingLotApplication {

    public static void main(String... args) throws Exception {

        ExecutorInterface fileExecutor = new FileExecutor();
        ExecutorInterface instructionExecutor = new InstructionExecutor();
        if(args.length > 0) {
            String fileName = args[0];
            try {
                BufferedReader bufferReader = (BufferedReader) fileExecutor.execute(fileName);
                instructionExecutor.execute(bufferReader);
                System.exit(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            instructionExecutor.execute(reader);
        }

    }
}
