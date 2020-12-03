package com.wf.training.bootapprestfulcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapprestfulcrud.entity.HistoricalRecordCompany;

@Repository
public interface CompanyHistoricalDataRepository extends JpaRepository<HistoricalRecordCompany, Long>{

}
