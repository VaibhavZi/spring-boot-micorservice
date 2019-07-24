package com.vz.bankaccountservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vz.bankaccountservice.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
