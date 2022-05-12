package com.scooty.scooty.table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "travel")
@Getter
@Setter
public class Travel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name ="travel_time_start")
    private LocalDateTime travelTimeStart;

    @Column (name="travel_time_stop")
    private LocalDateTime travelTimeStop;

    @Column (name= "start_point_latitude")
    private double startPointLatitude;

    @Column (name="start_point_longitude")
    private double startPointLongitude;

    @Column (name = "finish_point_latitude")
    private double finishPointLatitude;

    @Column (name = "finish_point_longitude")
    private double finishPointLongitude;

    @JoinColumn (name = "id_transport")
    @ManyToOne
    private Transport transport;

    @JoinColumn (name = "id_user")
    @ManyToOne
    private User user;

    @JoinColumn (name = "card_id")
    @ManyToOne
    private BankCard card;
}
