package com.securebank.securebank.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "remployee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private int idEmployee;
    @Column(name = "full_name_employee")
    private String fullNameEmployee;
    @Column(name = "address")
    private String address;
    @Column(name = "telephone_employee")
    private String telephoneEmployee;
    @Column(name = "birth_date")
    private Date date;
    @Column(name = "gender")
    private String gender;
    @Column(name = "family_status")
    private String familyStatus;
    @Column(name = "kids")
    private String kids;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_division")
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_position")
    private Position position;
}
