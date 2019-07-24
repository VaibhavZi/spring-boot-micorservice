package com.vz.bankaccountservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vz.bankaccountservice.dao.AccountDao;
import com.vz.bankaccountservice.model.Account;
import com.vz.bankaccountservice.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;
	
	public List<Account> getAllBankAccounts(int bankCode){
		return accountDao.getBankAccounts(bankCode);
	}
}
