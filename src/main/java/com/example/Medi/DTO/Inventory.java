package com.example.Medi.DTO;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@Entity
@Table
public class Inventory {
    @Id
    @Column
    String batch;
    @Column
    String code;
    @Column
    String name;
    @Column
    int stock;
    @Column
    int deal;
    @Column
    int free;
    @Column
    double mrp;
    @Column
    double rate;
    @Column
    String exp;
    @Column
    String company;
    @Column
    String supplier;
}