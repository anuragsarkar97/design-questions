package io.gojek.parkinglot.costants;

import java.util.ArrayList;

public class ParkingLotConstants {

    public static final ArrayList<String> statusHeaders = new ArrayList<String>();
    static {
        statusHeaders.add("Slot No.");
        statusHeaders.add("Registration No");
        statusHeaders.add("Color");
    }
    public static String FILE_NOT_FOUND = "File not found";
    public static String EXCEPTION_OCCURRED = "Exception raised with : {}";
}
