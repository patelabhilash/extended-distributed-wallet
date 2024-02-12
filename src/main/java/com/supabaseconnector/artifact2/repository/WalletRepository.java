package com.supabaseconnector.artifact2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supabaseconnector.artifact2.entity.Wallet;
import com.supabaseconnector.artifact2.util.Constraints.WalletType;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

  Wallet findByWalletId(String walletId);
  
  void deleteByWalletId(String walletId);

  long countByWalletType(WalletType walletType);

}