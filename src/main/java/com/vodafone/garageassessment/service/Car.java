package com.vodafone.garageassessment.service;

import com.vodafone.garageassessment.enums.VehicleSize;

public class Car extends Vehicle{
    public Car(String licensePlate, String color)
    {
        slotsNeeded = 1;
        size = VehicleSize.CAR;
        this.licensePlate = licensePlate;
        this.color = color;
    }
    public boolean canFitInSlot(ParkingSlot spot) {
        return spot.getSize() == VehicleSize.CAR || spot.getSize() == VehicleSize.JEEP || spot.getSize() == VehicleSize.CAR || spot.getSize() == VehicleSize.EMPTY;
    }
}
