package com.scooty.scooty.table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name="service_history")
@Getter
@Setter
public class ServiceHistory {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time")
    private Timestamp time;

    @Column (name ="description")
    private String descripton;

    @JoinColumn (name = "id_transport")
    @ManyToOne
    private Transport transport;
}
