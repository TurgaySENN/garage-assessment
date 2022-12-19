package com.vodafone.garageassessment.service;

import com.vodafone.garageassessment.enums.VehicleSize;

public class Truck extends Vehicle{
    public Truck(String licensePlate, String color)
    {
        slotsNeeded = 4;
        size = VehicleSize.TRUCK;
        this.licensePlate = licensePlate;
        this.color = color;
    }
    public boolean canFitInSlot(ParkingSlot spot) {
        return spot.getSize() == VehicleSize.TRUCK || spot.getSize() == VehicleSize.EMPTY;
    }
}
