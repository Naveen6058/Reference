package com.wf.training.bootapprestfulcrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapprestfulcrud.entity.InvestorWallet;
@Repository
public interface InvestorWalletRepository extends JpaRepository<InvestorWallet, Long>{
	
	Optional<InvestorWallet> findByInvestorID(int investorId);

}
