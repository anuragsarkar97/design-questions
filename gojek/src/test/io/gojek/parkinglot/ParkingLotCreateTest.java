package io.gojek.parkinglot;


import io.gojek.parkinglot.executor.ExecutorInterface;
import io.gojek.parkinglot.executor.InstructionExecutor;
import io.gojek.parkinglot.models.ParkingLot;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class ParkingLotCreateTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    InstructionExecutor instructionExecutor = new InstructionExecutor();


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void createLotTest() throws Exception {
        String[] array =  {"create_parking_lot", "6"};
        instructionExecutor.executeInstruction(new ParkingLot(), array);
        assertEquals("Created a parking lot with 6 slots\n", outContent.toString());

    }
}
