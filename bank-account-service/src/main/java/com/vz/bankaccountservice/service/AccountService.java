package com.vz.bankaccountservice.service;

import java.util.List;

import com.vz.bankaccountservice.model.Account;

public interface AccountService {
	
	public List<Account> getAllBankAccounts(int bankCode);

}
