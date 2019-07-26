package com.barclays.ipfp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barclays.ipfp.dao.TransactionDetailsDao;
import com.barclays.ipfp.dao.impl.TransactionDetailsDaoImpl;
import com.barclays.ipfp.model.TransactionDetails;
import com.barclays.ipfp.service.TransactionDetailsService;

@Component
public class TransactionDetailsServiceImpl implements TransactionDetailsService {
	@Autowired
	private TransactionDetailsDao tractionDao;

	@Override
	public void saveTransactionDetails(TransactionDetails details) {
		tractionDao.saveTransactionDetails(details);
	}

	@Override
	public void saveAllTransactionDetails(List<TransactionDetails> list) {
		tractionDao.saveAllTransactionDetails(list);
		
	}

}
