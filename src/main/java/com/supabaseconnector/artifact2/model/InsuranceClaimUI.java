package com.supabaseconnector.artifact2.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceClaimUI {
    // InsuranceClaim class

    private long accidentRepairExpenseId; // system input

    private LocalDate claimReceivedDate; // user input

    private long transactionId; // 0 == oId //system input

    // for FTL
    private long financialTransactionLogId; // system input

    private String note; // user input

    private String additionalDesc; // user input

    private LocalDate transactionDate; // user input that is already selected

    private LocalDate lastUpdatedDate; // system input

    private String lastUpdatedDeviceId; // system input

    private long paidByWalletId; // user input

    private long paidToWalletId; // system input of vehicle ID

    private long amount; // user input

}
