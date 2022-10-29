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
    String stock;
    @Column
    String deal;
    @Column
    String free;
    @Column
    String mrp;
    @Column
    String rate;
    @Column
    String exp;
    @Column
    String company;
    @Column
    String supplier;
}