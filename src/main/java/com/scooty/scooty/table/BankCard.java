package com.scooty.scooty.table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "bank_cards")
@Getter
@Setter
public class BankCard {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name ="number_bank_card")
    private String numberBankCard;

    @Column (name = "card_date")
    private LocalDate cardDate;

    @Column (name = "card_cvc")
    private int cardCvc;

    @JoinColumn (name = "id_user")
    @OneToOne
    private User user;
}
