package com.supabaseconnector.artifact2.model;

import java.util.Date;

public class InsuranceClaimUI {
    // InsuranceClaim class

    private long accidentRepairExpenseId; // system input

    private Date claimReceivedDate; // user input

    private long transactionId; // 0 == oId //system input

    // for FTL
    private long financialTransactionLogId; // system input

    private String note; // user input

    private String additionalDesc; // user input

    private Date transactionDate; // user input that is already selected

    private Date lastUpdatedDate; // system input

    private String lastUpdatedDeviceId; // system input

    private long paidByWalletId; // user input

    private long paidToWalletId; // system input of vehicle ID

    private long amount; // user input

}