package com.vz.bankservice.dao;
import com.vz.bankservice.domain.Bank;

import java.util.List;

public interface BankDao{
    public List<Bank> getAllBanks();
    public Bank addBank(Bank bank);
    public Bank getBankById(int id);
    public Bank updateBankDetails(Bank bank);
    public Bank deleteBankDetails(int bankId, String bankName);
}
