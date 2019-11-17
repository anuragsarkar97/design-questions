package io.gojek.parkinglot.models;

import io.gojek.parkinglot.models.enums.Color;
import io.gojek.parkinglot.models.enums.SlotStatus;
import sun.applet.resources.MsgAppletViewer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Parking lot class
 * has : list of slots
 * has : color to registration number to slot number
 */
public class ParkingLot {

    private List<Slot> slots;
    private Map<Color, Map<String, Integer>> colorSegmentMap;

    public ParkingLot(int parkingLotSize) {
        Slot[] array = new Slot[parkingLotSize];
        for (int i = 0; i< parkingLotSize; i++ ) {
            array[i] = new Slot();
        }
        this.slots= Arrays.asList(array);
        this.colorSegmentMap = new HashMap<Color, Map<String, Integer>>();
        for(Color color: Color.values()) {
            this.colorSegmentMap.put(color, new HashMap<String, Integer>());
        }
    }

    public ParkingLot() {
        Slot[] array = new Slot[1];
        this.slots= Arrays.asList(array);
        this.colorSegmentMap = new HashMap<Color, Map<String, Integer>>();
        for(Color color: Color.values()) {
            this.colorSegmentMap.put(color, new HashMap<String, Integer>());
        }
    }

    public Map<Color, Map<String, Integer>> getColorSegmentMap() {
        return colorSegmentMap;
    }

    public void setColorSegmentMap(Map<Color, Map<String, Integer>> colorSegmentMap) {
        this.colorSegmentMap = colorSegmentMap;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "slots=" + slots +
                ", colorSegmentMap=" + colorSegmentMap +
                '}';
    }
}
