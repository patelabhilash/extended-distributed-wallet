package com.supabaseconnector.artifact2.util;

public interface Constraints {

    public enum TransactionType {
        J, RE, BO, N, I, UNLISTED;
    }

    public enum UnlistedTransactionSampleReason {
        advance, advance_for_repair, advance_for_journey_of_the_route_NPD_BBS_13_12_2021, unlisted;
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
    enum DefaultWalletName {
        // Hidden_E
        Route_NPD_BBS_0730PM,
        Route_BBS_NPD_0730PM,
        Route_BBS_KOL_0830AM,
        Route_KOL_BBS_0200PM,
        VehicleRepair_OD02BM2219,
        VehicleRepair_OD02BK2219,
        Route_Tourist_sameDayArrival,
        Route_Tourist_nextDayArrival,
        // GovtPaperWorks_E
        TransportOffice_BBS,
        RTO_02,
        RTO_33,
        RTO_26,
        black,
        // Association_E
        Association_BBS,
        Association_CTC,
        Association_Dhenkanal,
        // Owner
        AP_I,
        AP_E,
        CKD_I,
        CKD_E,
        AP_CKD_I,
        AP_CKD_E,
        // Locker
        Locker_Sesu_House_I,
        Locker_CKD_BBS_House_I,
        // Bank will always be external as the application is only tracking cash at hand
        Main_SBI_E,
        AP_AXIS_E,
        CKD_SBI_E,
        CKD_AXIS_E,
        // Employee
        EMP_shortname01_I,
        EMP_shortname01_E,
        EMP_shortname02_I,
        EMP_shortname02_E,
        EMP_Sesu_I,
        EMP_Sesu_E,
        // ImportantPerson_E
        Investor_Bhai,
        Investor_Nanda,
        GovtEmp01,
        // miscellaneous_E
        business_maintenance_expansion,
        miscellaneous,
        // Adjustment_E
        Adjustment;
    }

    // walletCategory that has E as suffix represents only external wallet
    // that does not have suffix may have both internal and external wallet
    public enum WalletCategory {
        Hidden_E, GovtPaperWorks_E, Association_E, Owner, Locker, Bank_E, Employee, ImportantPerson_E, miscellaneous_E,
        Adjustment_E;
    }

    public enum EmployeeRole {
        MANAGER, CONDUCTOR, DRIVER, HELPER, UNLISTED;
    }

    public enum AccidentStatus {
        CREATED, REPAIRED, CLAIMED;
    }

}