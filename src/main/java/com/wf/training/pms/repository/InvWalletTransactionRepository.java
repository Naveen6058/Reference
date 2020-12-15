package com.wf.training.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.pms.entity.InvestorWalletTransaction;

@Repository
public interface InvWalletTransactionRepository extends JpaRepository<InvestorWalletTransaction, Long>{

}
