package com.scooty.scooty.controllers;

import com.scooty.scooty.model.OutputParkingPlace;
import com.scooty.scooty.model.OutputTransport;
import com.scooty.scooty.services.TransportService;
import com.scooty.scooty.table.ParkingPlace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    TransportService transportService;

    @GetMapping("parking-places")
    @Transactional
    public List<OutputParkingPlace> getByDistance(@RequestParam(name = "userLongitude") Double userLongitude,
                                                  @RequestParam(name = "userLatitude") Double userLatitude,
                                                  @RequestParam(name = "maxDist") Double maxDist,
                                                  @RequestParam(name="batteryLevel") Double batteryLevel) {
        var parkingPlaces = this.transportService.getParkingPlacesByDistance(userLongitude, userLatitude, maxDist);
        List<OutputParkingPlace> outputParkingPlaces = new ArrayList<>();
        for (ParkingPlace parkingPlace : parkingPlaces) {
            outputParkingPlaces.add(OutputParkingPlace.fromParkingPlace(parkingPlace, batteryLevel));
        }
        return outputParkingPlaces;
    }
    @GetMapping("qr-code")
    @Transactional
    public OutputTransport getByQrCode(@RequestParam(name ="qrCode") String qrCode){
       return transportService.getTransportByQrCodeValue(qrCode);
    }

}
