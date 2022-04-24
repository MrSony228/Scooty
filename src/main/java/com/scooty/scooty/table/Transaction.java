package com.scooty.scooty.table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table (name = "transaction")
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "sum")
    private double sum;

    @Column (name = "operation_time")
    private LocalDateTime operationTime;

    @JoinColumn (name = "id_travel")
    @OneToOne
    private Travel travel;

    @JoinColumn (name = "id_card")
    @ManyToOne
    private BankCards bankCards;
}
