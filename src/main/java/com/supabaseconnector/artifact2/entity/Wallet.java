package com.supabaseconnector.artifact2.entity;

import com.supabaseconnector.artifact2.util.Constraints.WalletType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    private long walletId;

    @Column(name = "wallet_type")
    private String walletType;

    @Column(name = "wallet_category")
    private String walletCategory;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @Column(name = "amount")
    private double amount; // the amount the wallet possess , to be updated in each transaction

}

