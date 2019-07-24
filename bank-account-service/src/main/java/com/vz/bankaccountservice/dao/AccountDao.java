package com.vz.bankaccountservice.dao;

import java.util.List;

import com.vz.bankaccountservice.model.Account;

public interface AccountDao {
	List<Account> getBankAccounts(int bankCode);
}
