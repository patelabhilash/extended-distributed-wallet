package com.supabaseconnector.artifact2.model;

import java.util.List;

import com.supabaseconnector.artifact2.entity.NonAccidentRepairExpensePaidSeparately;
import com.supabaseconnector.artifact2.entity.OtherTransaction;
import com.supabaseconnector.artifact2.entity.jour.Journey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionList {
    private List<Journey> journeyList;
    private List<NonAccidentRepairExpensePaidSeparately> nonAccidentRepairPaidSeparatelyList;
    private List<OtherTransaction> otherTransactionList;
}
