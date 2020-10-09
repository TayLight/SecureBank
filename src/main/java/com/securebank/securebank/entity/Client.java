package com.securebank.securebank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rclient")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private int idClient;
    @Column(name = "login_client")
    private String loginClient;
    @Column(name = "password_client")
    private String passwordClient;
    @Column(name = "full_name_client")
    private String fullNameClient;
    @Column(name = "passport_number")
    private String passport_number;
    @Column(name = "telephone_client")
    private String telephoneClient;
    @Column(name = "gender")
    private String gender;
}
