package com.vz.bankservice.resources;

import com.vz.bankservice.dao.BankDao;
import com.vz.bankservice.dao.impl.BankDaoImpl;
import com.vz.bankservice.domain.Bank;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BankResourceTest {

    @Autowired
    BankDao bankDao;
    public static List<Bank> banks = Arrays.asList();

    @Test
    public void getAllBanksWhenThereIsNoBank() {
        List<Bank> allBanks = banks.subList(0,0);
        assertEquals(allBanks.size(), 0);
    }

    @Test
    public void getAllBanks() {
//        int size = banks.size();
  //      assertEquals(size, 4);
    }

    @Test
    public void addBank() {
        /*        if(numberOfBanks!=0){
            bankDao.addBank(new Bank(1004, "BOB", "India","Bank of Badoda", "Private Sector"));
            assertEquals(numberOfBanks+1, bankDao.addBank(new Bank(1004, "BOB", "India","Bank of Badoda", "Private Sector")));
        }*/

    }

    @Test
    public void getBankDetails() {
    }

    @Test
    public void updateBankDetails() {
    }

    @Test
    public void deleteBank() {
    }
}