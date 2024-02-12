package com.supabaseconnector.artifact2.entity;

import com.supabaseconnector.artifact2.entity.Constraints.WalletType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Column(name = "wallet_id")
    private long walletId;

    @Column(name = "wallet_type")
    private WalletType walletType;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @Column(name = "amount")
    private double amount; // the amount the wallet possess , to be updated in each transaction

}

