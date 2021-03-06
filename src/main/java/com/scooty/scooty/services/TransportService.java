package com.scooty.scooty.services;

import com.scooty.scooty.model.OutputTransport;
import com.scooty.scooty.table.ParkingPlace;
import com.scooty.scooty.table.Transport;

import java.util.List;

public interface TransportService {

    List<ParkingPlace> getParkingPlacesByDistance(Double userLongitude, Double userLatitude, Double maxDist);
    OutputTransport getTransportByQrCodeValue(String qrCode);

    Transport editFree(int Id, Boolean free);

}
