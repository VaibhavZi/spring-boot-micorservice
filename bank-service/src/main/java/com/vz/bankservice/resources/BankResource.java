package com.vz.bankservice.resources;


import com.vz.bankservice.domain.Bank;
import com.vz.bankservice.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class BankResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BankService bankService;

    @RequestMapping(path = "/bank", method = RequestMethod.GET)
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    @RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<Bank> addBank(@RequestBody Bank bank) {
        if (bank==null || bank.getBankName().isEmpty()||bank.getCountry().isEmpty()) {
            Bank addedbank = bankService.addBank(bank);
            return new ResponseEntity<Bank>(addedbank, HttpStatus.CREATED);
        } else
            return new ResponseEntity<Bank>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/bank/{bankId}", produces = "application/json")
    public ResponseEntity<Bank> getBankDetails(@PathVariable("bankId") int bankId) {
            Bank bank = bankService.getBank(bankId);
            if(bank==null)
                return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
             else
                return new ResponseEntity<Bank>(bank, HttpStatus.FOUND);
    }

    @PutMapping(path = "/bank", consumes = "application/json")
    public ResponseEntity<Bank> updateBankDetails(@RequestBody Bank bank) {
            Bank updatedBank = bankService.updateBank(bank);
            if(updatedBank==null)
                return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<Bank>(updatedBank, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/deletebank/bankid/{bankId}/bankname/{bankName}")
    public ResponseEntity<Bank> deleteBank(@PathVariable("bankId") int bankId, @PathVariable("bankName")String bankName) {
        Bank bank1 = bankService.deleteBankDetails(bankId, bankName);
        if(bank1!=null)
            return new ResponseEntity<Bank>(bank1, HttpStatus.ACCEPTED);
        else return new ResponseEntity<Bank>(HttpStatus.NOT_FOUND);
    }
}
