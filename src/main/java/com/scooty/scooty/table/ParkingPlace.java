package com.scooty.scooty.table;

import com.grum.geocalc.Coordinate;
import com.grum.geocalc.EarthCalc;
import com.grum.geocalc.Point;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "parking_place")
@Getter
@Setter
public class ParkingPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "latitude")
    private double latitude;

    @Column(name= "longitude")
    private double longitude;

    @Column (name = "radius")
    private double radius;

    @OneToMany(mappedBy = "parkingPlace")
    private Set<Transport> transports;

    public boolean userInPoint(double userLat, double userLng, double maxDist) {

        Coordinate lat = Coordinate.fromDegrees(userLat);
        Coordinate lng = Coordinate.fromDegrees(userLng);
        Point user = Point.at(lat, lng);

        lat = Coordinate.fromDegrees(getLatitude());
        lng = Coordinate.fromDegrees(getLongitude());
        Point dot = Point.at(lat, lng);
        double dist = EarthCalc.vincenty.distance(user, dot);
        return dist <= maxDist;
    }
}
