package com.securebank.securebank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jtransaction")
public class Transact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private int idTransact;
    @Column(name = "payment_amount")
    private double payment_amount;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "payee")
    private Client payee;
}
