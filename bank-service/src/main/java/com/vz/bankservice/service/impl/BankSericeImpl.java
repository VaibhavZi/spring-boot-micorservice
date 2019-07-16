package com.vz.bankservice.service.impl;

import com.vz.bankservice.domain.Bank;
import com.vz.bankservice.dao.BankDao;
import com.vz.bankservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BankSericeImpl implements BankService {

    @Autowired
    BankDao bankDao;

    @Override
    public Bank addBank(Bank bank) {
        return bankDao.addBank(bank);
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankDao.getAllBanks();
    }

    @Override
    public Bank getBank(int id) {
        return bankDao.getBankById(id);
    }

    @Override
    public Bank updateBank(Bank bank) {
        return bankDao.updateBankDetails(bank);
    }

    @Override
    public Bank deleteBankDetails(int bankId, String bankName) {
        return bankDao.deleteBankDetails(bankId, bankName);
    }
}
