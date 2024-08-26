package com.scaa.wardrobe.enums;

public enum Season {
    SUMMER("summer", 0),
    WINTER("winter", 1);

    private String stringValue;
    private int intValue;

    private Season(String toString, int value) {
        stringValue = toString;
        intValue = value;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
