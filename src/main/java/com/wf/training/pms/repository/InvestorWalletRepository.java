package com.wf.training.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.wf.training.pms.entity.InvestorWallet;

@Repository
public interface InvestorWalletRepository extends JpaRepository<InvestorWallet, Long>{
	
	Optional<InvestorWallet> findByInvestorID(int investorId);

}
