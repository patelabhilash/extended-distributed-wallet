package com.supabaseconnector.artifact2.model;

import java.util.List;

import com.supabaseconnector.artifact2.entity.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InitHolder {
    
    private String datainfo;
    private List<String> owners;
    private List<String> lockers;
    private List<String> banks;
    private List<String> importants;
    private List<Wallet> wallets;
}
