package io.gojek.parkinglot.costants;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotConstants {

    public static final List<String> statusHeaders = new ArrayList<>();

    static {
        statusHeaders.add("Slot No.");
        statusHeaders.add("Registration No");
        statusHeaders.add("Color");
    }

    public static String FILE_NOT_FOUND = "File not found";
    public static String ALLOCATED_SPACE = "Allocated slot number: ";
    public static String SLOT_NUMBER = "Slot number ";
    public static String FREE_SPACE = " is free";
    public static String NOT_FOUND = "Not found";
    public static String NO_VEHICLE_FOUND = "No vehicles found";
    public static String CREATED_PARKING_LOT = "Created a parking lot with ";
    public static String INVALID_COMMAND = "Invalid Command found";
    public static String INVALID_SIZE = "Invalid size";
    public static String INVALID_INPUT = "Invalid Input";
}
