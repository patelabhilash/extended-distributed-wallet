package com.supabaseconnector.artifact2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.Wallet;
import com.supabaseconnector.artifact2.util.Constraints.WalletType;

public interface WalletRepository extends JpaRepository<Wallet, String> {

  Wallet findByWalletName(String walletName);
  
  void deleteByWalletName(String walletName);

  long countByWalletType(WalletType walletType);

}