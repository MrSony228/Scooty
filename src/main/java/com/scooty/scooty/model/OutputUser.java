package com.scooty.scooty.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class OutputUser {
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String seriesPassport;
    private String numberPassport;
    private String seriesDriverLicense;
    private String numberDriverLicense;
    private LocalDate birthdate;
}
