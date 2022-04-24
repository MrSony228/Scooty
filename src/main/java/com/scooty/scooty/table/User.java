package com.scooty.scooty.table;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private LocalDateTime birthdate;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "email")
    @NaturalId
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "series_passport")
    private String seriesPassport;

    @Column(name = "number_passport")
    private String numberPassport;

    @Column(name = "series_driver_license")
    private String seriesDriverLicense;

    @Column(name = "number_driver_license")
    private String numberDriverLicense;

    @Column(name = "deleted")
    private boolean deleted;

    @Column(name ="confirmed")
    private  boolean confirmed;
}
