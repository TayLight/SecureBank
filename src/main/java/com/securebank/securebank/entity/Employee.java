package com.securebank.securebank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "remployee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private int idEmployee;
}
