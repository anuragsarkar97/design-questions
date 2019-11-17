package io.gojek.parkinglot.costants;

import java.util.ArrayList;

public class ParkingLotConstants {

    public static final ArrayList<String> statusHeaders = new ArrayList<String>();
    static {
        statusHeaders.add("Slot No.");
        statusHeaders.add("Registration No");
        statusHeaders.add("Color");
    }
}
