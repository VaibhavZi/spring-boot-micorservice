package com.vz.bankaccountservice.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vz.bankaccountservice.dao.AccountDao;
import com.vz.bankaccountservice.model.Account;


@Component
public class AccountDaoImpl implements AccountDao{

	@Override
	public List<Account> getBankAccounts(int bankCode) {
		List<Account> accounts = new ArrayList<>();
		Account account = new Account();
		account.setAccountNumber(10000); account.setBankCode(bankCode);
		accounts.add(account);
		return accounts;
	}

}
