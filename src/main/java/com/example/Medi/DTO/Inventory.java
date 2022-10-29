package com.example.Medi.DTO;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "Inventory")
public class Inventory {
    @Column
    String code;
    @Column
    String name;
    @Id
    @Column
    String batch;
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