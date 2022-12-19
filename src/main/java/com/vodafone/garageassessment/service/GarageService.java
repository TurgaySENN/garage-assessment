package com.vodafone.garageassessment.service;

import com.vodafone.garageassessment.Request.RequestPark;
import com.vodafone.garageassessment.Response.ResponsePark;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GarageService implements IGarageService {
    private final Garage garage = new Garage(10);
    @Override
    public ResponsePark createPark(RequestPark request){
        if(null == request){
            return null;
        }
        ResponsePark responseTicket = new ResponsePark();
        responseTicket.setColor(request.getColor());
        responseTicket.setLicensePlate(request.getLicensePlate());
        if("Car".equals(request.getVehicleType())){
            Car car = new Car(request.getLicensePlate(), request.getColor());
            garage.parkVehicle(car);
            responseTicket.setTicketId(car.ticketId);
            responseTicket.setYourSlots("Your Slot/Slots:" + getStatus(car.ticketId));
        }
        else if("Jeep".equals(request.getVehicleType())){
            Jeep jeep = new Jeep(request.getLicensePlate(), request.getColor());
            garage.parkVehicle(jeep);
            responseTicket.setTicketId(jeep.ticketId);
            responseTicket.setYourSlots("Your Slot/Slots:" + getStatus(jeep.ticketId));
        }
        else if("Truck".equals(request.getVehicleType())){
            Truck truck = new Truck(request.getLicensePlate(), request.getColor());
            garage.parkVehicle(truck);
            responseTicket.setTicketId(truck.ticketId);
            responseTicket.setYourSlots("Your Slot/Slots is" + getStatus(truck.ticketId));
        }else{
            return null;
        }
        return responseTicket;
    }

    @Override
    public String leavePark(String ticketId){
        if(null == ticketId) {
            return "Ticket id must not be blank!";
        }
        garage.removeVehicle(garage.getVehicleByTicketId(ticketId));
        return "Good bye, we are waiting for you again.";
    }
    @Override
    public ArrayList<ResponsePark> getStatus(){
        ArrayList<ResponsePark> responseList = new ArrayList<ResponsePark>();
        for(int i=0; i< garage.getSlots().length; i++){
            ResponsePark responsePark = new ResponsePark();
            Vehicle vh = garage.getSlots()[i].getVehicle();
            if(null == vh){
                continue;
            }
            responsePark.setColor(vh.color);
            responsePark.setTicketId(vh.ticketId);
            responsePark.setLicensePlate(vh.licensePlate);
            responsePark.setYourSlots("Your Slot/Slots is :" + getStatus(vh.ticketId));
            responseList.add(responsePark);
            i += vh.getSize().getValue() - 1;
        }
        return responseList;
    }
    public String getStatus(String ticketId){
        if(null == ticketId){
            return "Ticket id must not be blank!";
        }
        Vehicle vh = garage.getVehicleByTicketId(ticketId);
        if(null == vh){
            return "The vehicle belonging to the ticket was not found.";
        }
        String returnString = "";
        for(ParkingSlot vehicle : vh.parkingSlots){
            returnString += " " + vehicle.getSlotNumber();
        }
        return returnString;
    }
    @Override
    public void testForLogs(){
        Car car1 = new Car("34-SO-188","Black");
        Car car2 = new Car("34-SO-1988","purple");
        Car car3 = new Car("34-SO-198","purple");
        Truck truck = new Truck("34-BO-1987", "Red");
        Jeep jeep = new Jeep("34-VO-2018","Blue");
        Truck truck2 = new Truck("34-HBO-2020","Black");
        garage.parkVehicle(car1);
        garage.parkVehicle(truck);
        garage.parkVehicle(jeep);
        garage.parkVehicle(car2);
        garage.removeVehicle(truck);
        garage.parkVehicle(car3);
        garage.parkVehicle(truck2);
        System.out.print("car1 slots:");
        car1.parkingSlots.forEach((n) -> System.out.print(" " + n.getSlotNumber()));
        System.out.println();
        System.out.println("car2 slots:");
        car2.parkingSlots.forEach((n) -> System.out.print(" " + n.getSlotNumber()));
        System.out.println();
        System.out.println("car3 slots:");
        car3.parkingSlots.forEach((n) -> System.out.print(" " + n.getSlotNumber()));
        System.out.println();
        System.out.println("truck slots:");
        truck.parkingSlots.forEach((n) -> System.out.print(" " + n.getSlotNumber()));
        System.out.println();
        System.out.println("jeep slots:");
        jeep.parkingSlots.forEach((n) -> System.out.print(" " + n.getSlotNumber()));
        System.out.println();
        System.out.println("truck2: slots");
        truck2.parkingSlots.forEach((n) -> System.out.print(" " + n.getSlotNumber()));
        System.out.println();
    }
}
