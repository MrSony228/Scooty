package com.scooty.scooty.services;

import com.scooty.scooty.repository.TravelRepository;
import com.scooty.scooty.table.BankCard;
import com.scooty.scooty.table.Transport;
import com.scooty.scooty.table.Travel;
import com.scooty.scooty.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private PaymentService paymentService;

    @Transactional
    public Travel getTravelById(int id) {
        return this.travelRepository.getById(id);
    }

    @Transactional
    public Travel travelStart(User user,
                              Transport transport,
                              BankCard bankCard,
                              double startPointLatitude,
                              double startPointLongitude,
                              LocalDateTime travelTimeStart,
                              double sum) {

        Travel travel = new Travel();

        travel.setTravelTimeStart(travelTimeStart);
        travel.setUser(user);
        travel.setTransport(transport);
        travel.setStartPointLongitude(startPointLongitude);
        travel.setStartPointLatitude(startPointLatitude);
        travel.setCard(bankCard);

        return this.travelRepository.save(travel);
    }

    @Transactional
    public void travelStop(Travel travel,
                           double stopPointLatitude,
                           double stopPointLongitude,
                           LocalDateTime travelTimeStop) {
        travel.setTravelTimeStop(travelTimeStop);
        travel.setFinishPointLatitude(stopPointLatitude);
        travel.setFinishPointLongitude(stopPointLongitude);
        double distance = calcDistance(travel.getStartPointLatitude(),
                       travel.getStartPointLongitude(),
                       stopPointLatitude,
                       stopPointLongitude);
        double sum = calcSum(distance);
        paymentService.payment(travel, sum);
        //TODO списать деньги
    }

    public double calcDistance(double startPointLatitude,
                                 double startPointLongitude,
                                 double stopPointLatitude,
                                 double stopPointLongitude) {
        double lat1 = Math.toRadians(startPointLatitude);
        double lon1 = Math.toRadians(startPointLongitude);
        double lat2 = Math.toRadians(stopPointLatitude);
        double lon2 = Math.toRadians(stopPointLongitude);
        double earthRadius = 6371000;
        return earthRadius * Math.acos(Math.sin(lat1)*Math.sin(lat2) + Math.cos(lat1)*Math.cos(lat2)*Math.cos(lon1 - lon2));

    }

    public double calcSum(double distance){
        return distance * 7;
    }

    @Transactional
    public Travel getActiveTravelByUserId(int id) {
        return this.travelRepository.getByUserIdAndTravelTimeStopIsNull(id);
    }
}
