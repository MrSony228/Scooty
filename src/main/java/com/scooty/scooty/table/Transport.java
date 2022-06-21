package com.scooty.scooty.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "transport")
@Getter
@Setter
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "battery_level")
    private int batteryLevel;

    @Column(name = "is_free")
    private boolean isFree;

    @Column(name = "description")
    private String description;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "qr_code_value")
    private String qrCodeValue;

    @Column(name = "price")
    private int price;

    @JsonIgnore
    @JoinColumn(name = "manufacturer_id")
    @ManyToOne
    private Manufacturer manufacturer;
    @JsonIgnore
    @JoinColumn(name = "id_parking")
    @ManyToOne
    private ParkingPlace parkingPlace;
}
