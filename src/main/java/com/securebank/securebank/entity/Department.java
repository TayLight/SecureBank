package com.securebank.securebank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cdivision")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_division")
    private int idDepartment;
    @Column(name = "name_division")
    private String nameDivision;
    @Column(name = "telephone_division")
    private String telephoneDivision;

}
