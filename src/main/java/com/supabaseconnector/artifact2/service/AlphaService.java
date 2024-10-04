package com.supabaseconnector.artifact2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supabaseconnector.artifact2.repository.DeviceRepository;
import com.supabaseconnector.artifact2.repository.FinancialTransactionLogRepository;
import com.supabaseconnector.artifact2.repository.OtherTransactionRepository;
import com.supabaseconnector.artifact2.repository.WalletRepository;

@Service
public class AlphaService {
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    FinancialTransactionLogRepository financialTransactionLogRepository;

    @Autowired
    OtherTransactionRepository otherTransactionRepository;

    //getTransactionByWeek
    

    //addFTLTransaction

    //addOtherTransaction


    //getWalletList

    //addWallet



}
