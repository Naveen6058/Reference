package com.wf.training.pms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.pms.entity.HistoricalRecordCompany;

@Repository
public interface CompanyHistoricalDataRepository extends JpaRepository<HistoricalRecordCompany, Long>{
	
	Optional<List<HistoricalRecordCompany>> findAllByCompanyCode(long companyCode);

}
