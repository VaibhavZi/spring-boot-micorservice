package com.vz.bankservice.service;

import com.vz.bankservice.domain.Bank;

import java.util.List;

public interface BankService {
    Bank addBank(Bank bank);
    List<Bank> getAllBanks();
    Bank getBank(int id);
    Bank updateBank(Bank bank);
    Bank deleteBankDetails(int bankId, String bankName);
}
