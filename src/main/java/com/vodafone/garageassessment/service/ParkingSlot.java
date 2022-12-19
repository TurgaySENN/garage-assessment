package com.vodafone.garageassessment.service;

import com.vodafone.garageassessment.enums.VehicleSize;

public class ParkingSlot {
    private Vehicle vehicle;
    private VehicleSize vSize;
    private int lane;
    private int slotNumber;

    public ParkingSlot(int l, int n,
                       VehicleSize s)
    {
        lane = l;
        slotNumber = n;
        vSize = s;
    }

    public boolean isAvailable()
    {
        return vehicle == null;
    }

    /* Check if the spot is big enough and is available */
    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.canFitInSlot(this);
    }

    /* Park vehicle in this spot. */
    public boolean park(Vehicle v) {
        if (!canFitVehicle(v))
        {
            return false;
        }

        vehicle = v;
        v.parkingSlot(this);
        return true;
    }

    public int getLane()
    {
        return lane;
    }
    public int getSlotNumber()
    {
        return slotNumber;
    }
    public Vehicle getVehicle()
    {
        return vehicle;
    }
    public VehicleSize getSize()
    {
        return vSize;
    }
    public void setSize(VehicleSize vSize)
    {
        this.vSize = vSize;
    }
    /* Remove vehicle from spot, and notify
      level that a new spot is available */
    public void removeVehicle() {
        vehicle = null;
        vSize = VehicleSize.EMPTY;
    }
}
