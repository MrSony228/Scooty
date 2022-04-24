package com.scooty.scooty.table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "manufacturer")
@Getter
@Setter
public class Manufacturer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
