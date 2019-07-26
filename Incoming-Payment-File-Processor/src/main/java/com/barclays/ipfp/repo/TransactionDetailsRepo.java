package com.barclays.ipfp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barclays.ipfp.model.TransactionDetails;

@Repository
public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails, Integer>{

}
