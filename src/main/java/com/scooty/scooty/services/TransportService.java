package com.scooty.scooty.services;

import com.scooty.scooty.table.ParkingPlace;

import java.util.List;

public interface TransportService {

    List<ParkingPlace> getParkingPlacesByDistance(Double userLongitude, Double userLatitude, Double maxDist);

}
