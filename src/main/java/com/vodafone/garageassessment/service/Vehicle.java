package com.vodafone.garageassessment.service;

import com.vodafone.garageassessment.enums.VehicleSize;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Vehicle {
    protected ArrayList<ParkingSlot> parkingSlots = new ArrayList<ParkingSlot>(10);
    protected String licensePlate;
    protected String color;
    protected int slotsNeeded;
    protected VehicleSize size;

    protected String ticketId = UUID.randomUUID().toString();

    public int getSlotsNeeded()
    {
        return slotsNeeded;
    }
    public VehicleSize getSize()
    {
        return size;
    }
    public void parkingSlot(ParkingSlot s)
    {
        parkingSlots.add(s);
    }
    public void clearSlots() {
        for (int i = 0; i < parkingSlots.size(); i++)
        {
            parkingSlots.get(i).removeVehicle();
        }
        parkingSlots.clear();
    }
    public abstract boolean canFitInSlot(ParkingSlot spot);
}
