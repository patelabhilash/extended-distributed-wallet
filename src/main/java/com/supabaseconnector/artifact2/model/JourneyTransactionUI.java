package com.supabaseconnector.artifact2.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JourneyTransactionUI {
    // JourneyTransaction class
    
    private boolean isIncome; //system input based on what you selected
    
    private long transactionId; // 0 == oId //system input

    //for FTL
    private long financialTransactionLogId; //system input

    private String note; //user input

    private String additionalDesc; //user input

    private Date transactionDate; //user input that is already selected

    private Date lastUpdatedDate; //system input

    private String lastUpdatedDeviceId; //system input

    private long paidByWalletId; //system input of route ID

    private long paidToWalletId; //system input of allotted (conductor) Employee ID

    private long amount; //user input
}
