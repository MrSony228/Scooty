package com.scooty.scooty.services;

import com.scooty.scooty.model.OutputTransport;
import com.scooty.scooty.repository.ParkingPlaceRepository;
import com.scooty.scooty.repository.TransportRepository;
import com.scooty.scooty.table.ParkingPlace;
import com.scooty.scooty.table.Transport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransportServiceImpl implements TransportService {

    final TransportRepository transportRepository;
    final ParkingPlaceRepository parkingPlaceRepository;

    @Override
    @Transactional
    public List<ParkingPlace> getParkingPlacesByDistance(Double userLongitude, Double userLatitude, Double maxDist) {
        List<ParkingPlace> parkingPlaces = parkingPlaceRepository.findAll();
        return parkingPlaces.stream().filter(parkingPlace -> parkingPlace.userInPoint(userLatitude, userLongitude, maxDist)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OutputTransport getTransportByQrCodeValue(String qrCode) {
       Transport transport = transportRepository.findByQrCodeValue(qrCode);
       OutputTransport result = new OutputTransport();
       result.setQrCodeValue(transport.getQrCodeValue());
       result.setId(transport.getId());
       result.setBatteryLevel(transport.getBatteryLevel());
       result.setDescription(transport.getDescription());
       result.setName(transport.getName());
       result.setFree(transport.isFree());
       result.setMileage(transport.getMileage());
       result.setManufacturer(transport.getManufacturer().getTitle());
        return result;
    }
}
