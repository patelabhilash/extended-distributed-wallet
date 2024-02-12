package com.supabaseconnector.artifact2.model;

import java.util.List;

import com.supabaseconnector.artifact2.entity.NonAccidentRepairPaidSeparately;
import com.supabaseconnector.artifact2.entity.OtherTransaction;
import com.supabaseconnector.artifact2.entity.journey.Journey;

public class TransactionList {
    private List<Journey> journeyList;
    private List<NonAccidentRepairPaidSeparately> nonAccidentRepairPaidSeparatelyList;
    private List<OtherTransaction> otherTransactionList;
}
