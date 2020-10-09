package com.securebank.securebank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cposition")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_position")
    private int idPosition;
    @Column(name = "name_position")
    private String namePosition;
    @Column(name = "salary")
    private int salary;
}
