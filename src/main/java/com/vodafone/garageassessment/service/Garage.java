package com.vodafone.garageassessment.service;

import com.vodafone.garageassessment.enums.VehicleSize;

public class Garage {

    private ParkingSlot[] slots;
    private int availableSlots = 0;
    private static final int SLOT_PER_ROW = 1;
    public Garage(int numberSlots)
    {
        availableSlots = numberSlots;
        slots = new ParkingSlot[numberSlots];
        VehicleSize size = VehicleSize.EMPTY;
        for (int j = 0; j < numberSlots; j++)
        {
            int row = j / SLOT_PER_ROW;
            slots[j] = new ParkingSlot(row, j, size);
        }
    }
    public int availableSlots()
    {
        return availableSlots;
    }
    public boolean parkVehicle(Vehicle vh)
    {
//find a place to park this vehicle, return false if failed
        if (availableSlots() < vh.getSlotsNeeded()){
            System.out.println("PARKING IS FULL FOR YOUR VEHICLE");
            return false;
        }
        int slotNumber = findAvailableSlots(vh);
        if (slotNumber < 0){
            System.out.println("PARKING IS FULL FOR YOUR VEHICLE");
            return false;
        }
        System.out.println(", Slot Number " + slotNumber);
        return parkStartingAtSlot(slotNumber, vh);
    }
    private boolean parkStartingAtSlot(int num, Vehicle vh)
    {
// park a vehicle at the slot slotNumber, and continuing till vehicle.slotsNeeded
        vh.clearSlots();
        boolean success = true;
        for (int j = num; j < num + vh.slotsNeeded; j++)
        {
            success &= slots[j].park(vh);
            slots[j].setSize(vh.getSize());
        }
        availableSlots = availableSlots - vh.slotsNeeded;
        return success;
    }

    // a method to find the vacant slot
    private int findAvailableSlots(Vehicle vh)
    {
        int slotsNeeded = vh.getSlotsNeeded();
        int lastRow = -1;
        int slotsFound = 0;

        for (int j = 0; j < slots.length; j++) {
            ParkingSlot spot = slots[j];
            if (slots[j].getSize() != VehicleSize.EMPTY && lastRow != slots[j].getLane()) {
                slotsFound = 0;
                lastRow = slots[j].getLane();
            }
            if (slots[j].canFitVehicle(vh)) {
                slotsFound = slotsFound + 1;
            } else {
                slotsFound = 0;
            }
            if (slotsFound == slotsNeeded) {
                if (slotsNeeded == VehicleSize.CAR.getValue()) {
                    System.out.print("It is a Car parked in ");
                } else if (slotsNeeded == VehicleSize.JEEP.getValue()) {
                    System.out.print("It is a Jeep parked in ");
                } else {
                    System.out.print("It is a Truck parked in ");
                }
                return j - (slotsNeeded - 1);
            }
        }
        return -1;
    }
    public void removeVehicle(Vehicle vh){
        String log = "New Available Slots:";
        for(ParkingSlot slot : vh.parkingSlots){
            slots[slot.getSlotNumber()].removeVehicle();
            log += " " + slot.getSlotNumber();
        }

        System.out.println(log);
        availableSlots += vh.slotsNeeded;
        vh.clearSlots();
    }

    public Vehicle getVehicleByTicketId(String ticketId){
        for(ParkingSlot slot : slots){
            if(ticketId.equals(slot.getVehicle().ticketId)){
                return slot.getVehicle();
            }
        }
        System.out.println("The vehicle belonging to the ticket was not found.");
        return null;
    }
    public ParkingSlot[] getSlots(){
        return slots;
    }
}
