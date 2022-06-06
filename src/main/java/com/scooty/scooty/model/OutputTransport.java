package com.scooty.scooty.model;

import com.scooty.scooty.table.Transport;
import lombok.Data;

@Data
public class OutputTransport {

    public static OutputTransport fromTransport(Transport transport) {
        OutputTransport outputTransport = new OutputTransport();
        outputTransport.setId(transport.getId());
        outputTransport.setName(transport.getName());
        outputTransport.setBatteryLevel(transport.getBatteryLevel());
        outputTransport.setMileage(transport.getMileage());
        outputTransport.setDescription(transport.getDescription());
        outputTransport.setFree(transport.isFree());
        outputTransport.setQrCodeValue(transport.getQrCodeValue());
        outputTransport.setPrice(transport.getPrice());
        outputTransport.setManufacturer(transport.getManufacturer().getTitle());
        outputTransport.setLatitude(transport.getParkingPlace().getLatitude());
        outputTransport.setLongitude(transport.getParkingPlace().getLongitude());
        return outputTransport;
    }

    private Integer id;
    private String name;
    private int batteryLevel;
    private boolean isFree;
    private String description;
    private int mileage;
    private String qrCodeValue;
    private String manufacturer;
    private int price;
    private double latitude;
    private double longitude;

}
