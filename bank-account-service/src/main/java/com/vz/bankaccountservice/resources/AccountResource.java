package com.vz.bankaccountservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vz.bankaccountservice.dao.AccountRepository;
import com.vz.bankaccountservice.model.Account;
import com.vz.bankaccountservice.model.Bank;
import com.vz.bankaccountservice.service.AccountService;

@RestController
@RequestMapping(path="/account")
public class AccountResource {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountRepository repository;
	
	
	@GetMapping(path="/bank/{bankId}/accounts")
	public ResponseEntity<List<Account>> getAllAccountsOfCustomer(@PathVariable("bankId") int bankCode){
		List<Account> allBankAccounts = null;
		if(bankCode <100000) {
			return new ResponseEntity<List<Account>>(HttpStatus.NOT_FOUND);
		}else {
			Bank bank = restTemplate.getForObject("http://bank-service/bank/"+bankCode, Bank.class);
			if(bank==null) {
				return new ResponseEntity<List<Account>>(HttpStatus.NOT_FOUND);
			} else {
				allBankAccounts = accountService.getAllBankAccounts(bankCode);
				return new ResponseEntity<List<Account>>(allBankAccounts, HttpStatus.OK);
			}
		}		
	}

	

}
