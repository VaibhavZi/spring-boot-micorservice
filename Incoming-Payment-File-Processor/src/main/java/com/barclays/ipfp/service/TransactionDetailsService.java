package com.barclays.ipfp.service;

import java.util.List;

import com.barclays.ipfp.model.TransactionDetails;

public interface TransactionDetailsService {
	void saveTransactionDetails(TransactionDetails details);
	public void saveAllTransactionDetails(List<TransactionDetails> list);

}
