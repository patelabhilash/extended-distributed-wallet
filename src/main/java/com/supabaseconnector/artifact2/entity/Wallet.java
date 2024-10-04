package com.supabaseconnector.artifact2.entity;

import com.supabaseconnector.artifact2.util.Constraints.WalletCategory;
import com.supabaseconnector.artifact2.util.Constraints.WalletType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @Column(name = "wallet_name")
    private String walletName;
    
    @Column(name = "description")
    private String description;

    
    @Enumerated(EnumType.STRING)
    @Column(name = "wallet_type")
    private WalletType walletType;

    @Enumerated(EnumType.STRING)
    @Column(name = "wallet_category")
    private WalletCategory walletCategory; 

    @Column(name = "amount")
    private double balance; // the amount the wallet possess , to be updated in each transaction

    @Column(name = "is_visible")
    private boolean isVisible;
}
