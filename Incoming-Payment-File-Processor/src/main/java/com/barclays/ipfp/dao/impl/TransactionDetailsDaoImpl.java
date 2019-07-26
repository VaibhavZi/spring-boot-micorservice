package com.barclays.ipfp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barclays.ipfp.dao.TransactionDetailsDao;
import com.barclays.ipfp.model.TransactionDetails;
import com.barclays.ipfp.repo.TransactionDetailsRepo;

@Service
@Transactional
public class TransactionDetailsDaoImpl implements TransactionDetailsDao{

	@Autowired
	TransactionDetailsRepo repo;
	
	@Override
	public void saveTransactionDetails(TransactionDetails details) {
		repo.save(details);
	}

	@Override
	public void saveAllTransactionDetails(List<TransactionDetails> list) {
		repo.saveAll(list);
		
	}

}
