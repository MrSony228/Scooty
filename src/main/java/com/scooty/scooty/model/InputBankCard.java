package com.scooty.scooty.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class InputBankCard {
    private String numberBankCard;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cardDate;
    private int cardCvc;
    private int userId;
}
