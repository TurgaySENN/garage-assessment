package com.vodafone.garageassessment.enums;

public enum VehicleSize {
    CAR(1), JEEP(2), TRUCK(4), EMPTY(0);
    private final int value;

    VehicleSize(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
