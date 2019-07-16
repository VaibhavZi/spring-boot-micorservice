package com.vz.bankservice.dao.impl;

import com.vz.bankservice.dao.BankDao;
import com.vz.bankservice.domain.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BankDaoImpl  implements BankDao {

    @Autowired
    private SessionFactory  sessionFactory;

    /**
     * This method look-up banks in database and returns all the branches
     * TODO : Additional logic can be applied to return specific number of rows
     * @return
     */
    @Override
    public List<Bank> getAllBanks() {
        Session session=sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Bank> bankList = session.createCriteria(Bank.class).list();
        return bankList;
    }

    /**
     * This method accepts the bank object, and saves it into database.
     * @param bank
     * @return
     */
    @Override
    public Bank addBank(Bank bank) {
        Session session = sessionFactory.getCurrentSession();
        bank.setDateCreated(LocalDateTime.now());
        session.save(bank);
        Bank addedBank = session.load(Bank.class, bank.getBankCode());
        return addedBank;
    }

    /**
     * This method searches bank in database with bankCode.
     * @param bankCode
     * @return
     */
    @Override
    public Bank getBankById(int bankCode) {
        Session session= sessionFactory.getCurrentSession();
        Bank bank = session.get(Bank.class, bankCode);
        return bank;
    }

    /**
     * This method accepts Bank object for modification. Same is updated into database.
     * @param bank
     * @return
     */
    @Override
    public Bank updateBankDetails(Bank bank) {
        Session session = sessionFactory.getCurrentSession();
        bank.setDateModified(LocalDateTime.now());
        session.update(bank);
        Bank updateBank = session.load(Bank.class, bank.getBankCode());
        return updateBank;
    }

    /**
     * This method accepts bankName and bankCode.
     * A validation is performed on the basis of values received to verify if the bank is present.
     * If bank is found with the given details, then it it is deleted.
     * @param bankCode
     * @param bankName
     * @return
     */
    @Override
    public Bank deleteBankDetails(int bankCode, String bankName) {
        Session session= sessionFactory.getCurrentSession();
        Bank loadedWithId = session.load(Bank.class, bankCode);
        if(loadedWithId!=null && loadedWithId.getBankName().equals(bankName)) {
            session.delete(loadedWithId);
        }return loadedWithId;
    }
}
