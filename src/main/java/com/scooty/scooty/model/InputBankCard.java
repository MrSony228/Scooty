package com.scooty.scooty.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InputBankCard {
    private String numberBankCard;
    private String cardDate;
    private int cardCvc;
    private int userId;
}
