package com.wf.training.bootapprestfulcrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wf.training.bootapprestfulcrud.entity.RecentlyViewedCompanies;

@Repository
public interface RecentViewCompRepository extends JpaRepository<RecentlyViewedCompanies, Long>{
	
	Optional<RecentlyViewedCompanies> findByLoginKeyAndCompanyTitle(String loginKey, String companyTitle);
	
	Optional<List<RecentlyViewedCompanies>> findAllByLoginKey(String loginKey);

}
