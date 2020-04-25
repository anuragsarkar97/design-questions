package io.gojek.parkinglot.models.enums;

public enum Color {
    White,
    Black,
    Blue,
    Red,
    InvalidColor;


    public static Color getColorByValue(String argument) {
        for (Color color : Color.values()) {
            if (color.name().equals(argument)) {
                return color;
            }
        }
        return InvalidColor;
    }

}
