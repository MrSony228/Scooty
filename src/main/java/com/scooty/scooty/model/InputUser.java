package com.scooty.scooty.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

}
