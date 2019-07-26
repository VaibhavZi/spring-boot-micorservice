package com.barclays.ipfp.dao;

import java.util.List;

import com.barclays.ipfp.model.TransactionDetails;

public interface TransactionDetailsDao {
	public void saveTransactionDetails(TransactionDetails details);
	public void saveAllTransactionDetails(List<TransactionDetails> list);
	
}
