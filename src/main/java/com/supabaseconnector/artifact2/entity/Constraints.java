package com.supabaseconnector.artifact2.entity;

public interface Constraints {

public enum TransactionType {
    J, RE, BO, N, I, UNLISTED;
}

/*
 * internal to internal is movement within wallet
 * internal to external is expense to combined wallet
 * external to internal is income to combined wallet
 * 
 * so, total money I have = SUM (internal wallet amounts)
 * 
 * external <-> external not allowed
 * 
 * 
 * a external can be an inverstor/loan giver/ to who we lend money
 * e.g. nanda, bhai, or someone CKD wants to help personally
 * external wallet amount will be tracked
 * only create new external whose dealings you want to track
 * those who you dont want to track put in misc.
 */
public enum WalletType {
    INTERNAL, EXTERNAL;
}

/*
 * suffix I means internal, E means external
 */
public enum WalletNameSuggestions {
    AP_E, CKD_E, CKD_LOCKER_I, SESU_LOCKER_I, INVESTOR_BHAI_E, INVESTOR_NANDA_E,
    INVESTOR_1_E, INVESTOR_2_E, OUTSIDER_NAME_E,
    REPAIR_SHOP_E, //REPAIR_SHOP to track repair expense
    JOURNEY_E, // To track journey transactions
    BANK_1_E, BANK_2_E, // select bank as bank interface
    ADJUSTMENT_E, //adjustment to get back on money miscalulated/ missed update ; we are tracking how much miscalc happened in total
    BUSINESS_EXPANSION_E, BUSINESS_MAINTENANCE_E,
    MANAGET_1_I, MANAGER_2_I, CONDUCTOR_1_I, CONDUCTOR_2_I,
    MISC_E; //miscellaneous 

}

public enum AccidentStatus {
    CREATED,REPAIRED,CLAIMED;

}

}