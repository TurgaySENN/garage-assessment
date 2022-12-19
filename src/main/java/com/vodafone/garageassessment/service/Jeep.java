package com.vodafone.garageassessment.service;

import com.vodafone.garageassessment.enums.VehicleSize;

public class Jeep extends Vehicle{
    public Jeep(String licensePlate, String color)
    {
        slotsNeeded = 2;
        size = VehicleSize.JEEP;
        this.licensePlate = licensePlate;
        this.color = color;
    }
    public boolean canFitInSlot(ParkingSlot spot) {
        return spot.getSize() == VehicleSize.TRUCK || spot.getSize() == VehicleSize.JEEP || spot.getSize() == VehicleSize.EMPTY;
    }
}
