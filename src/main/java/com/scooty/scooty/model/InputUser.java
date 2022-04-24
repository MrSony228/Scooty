package com.scooty.scooty.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InputUser {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String password;
    private String seriesPassport;
    private String numberPassport;
    private String seriesDriverLicense;
    private String numberDriverLicense;
    private LocalDateTime birthdate;

}
