package com.wf.training.bootapprestfulcrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapprestfulcrud.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
	Optional<Company> findBycompanyTitle(String companyTitle);
}


