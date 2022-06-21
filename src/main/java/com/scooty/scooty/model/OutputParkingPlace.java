package com.scooty.scooty.model;

import com.scooty.scooty.table.ParkingPlace;
import com.scooty.scooty.table.Transport;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class OutputParkingPlace {

    public static OutputParkingPlace fromParkingPlace(ParkingPlace parkingPlace, double batteryLevel) {
        OutputParkingPlace outputParkingPlace = new OutputParkingPlace();
        outputParkingPlace.setId(parkingPlace.getId());
        outputParkingPlace.setLatitude(parkingPlace.getLatitude());
        outputParkingPlace.setLongitude(parkingPlace.getLongitude());
        outputParkingPlace.setRadius(parkingPlace.getRadius());
        Set<OutputTransport> transports = new HashSet<>();
       for (Transport transport : parkingPlace.getTransports()) {
            if (transport.getBatteryLevel() >= (int) batteryLevel) {
                if(transport.isFree() == true) {
                    transports.add(OutputTransport.fromTransport(transport));
                }
            }
        }
        outputParkingPlace.setTransports(transports);
        return outputParkingPlace;
    }


    private int id;
    private double latitude;
    private double longitude;
    private double radius;
    private Set<OutputTransport> transports;

}
