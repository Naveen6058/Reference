package com.wf.training.bootapprestfulcrud.service;

import java.util.List;

import com.wf.training.bootapprestfulcrud.dto.CompanyHistoricalDataOutputDto;

public interface CompanyHistoricalDataService {
	
	public List<CompanyHistoricalDataOutputDto> fetchAllCompanies();
//	public CompanyHistoricalDataOutputDto fetchSingleCompany(Long id);
//	public CompanyHistoricalDataOutputDto addCompany(SearchCompanyInputDto employeeInputDto);
//	public CompanyHistoricalDataOutputDto editCompany(Long id, SearchCompanyInputDto employeeInputDto);
//	public CompanyHistoricalDataOutputDto deleteCompany(Long id);	
	List<CompanyHistoricalDataOutputDto> fetchSingleByCompanyId(Long companyCode);

}
