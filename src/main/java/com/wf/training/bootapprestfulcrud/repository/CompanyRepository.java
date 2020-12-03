package com.wf.training.bootapprestfulcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapprestfulcrud.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{
    // nothing to add
}


