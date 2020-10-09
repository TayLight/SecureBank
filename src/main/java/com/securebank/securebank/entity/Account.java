package com.securebank.securebank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jaccount")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private int idAccount;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "amount")
    private double amount;
    @Column(name = "currency")
    private String currency;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "id_client")
    private Client client;
}
