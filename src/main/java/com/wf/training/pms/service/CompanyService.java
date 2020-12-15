package com.wf.training.pms.service;

import java.util.List;

import com.wf.training.pms.dto.StockPriceDto;
import com.wf.training.pms.dto.CompanyDto;
import com.wf.training.pms.dto.SearchCompanyDto;


public interface CompanyService {

	public List<CompanyDto> fetchAllCompanies();
	public CompanyDto fetchSingleCompany(Long id);
	public CompanyDto addCompany(CompanyDto addCompanyInputDto);
	public CompanyDto editCompany(Long id, SearchCompanyDto employeeInputDto);
	public CompanyDto deleteCompany(Long id);
	public CompanyDto fetchSingleCompanyByName(SearchCompanyDto searchCompanyDto);
	public CompanyDto fetchSingleCompanyByName(String companyTitle);
	public CompanyDto modifyCompany(CompanyDto companyOutputDto);
	public boolean addStockPrice(StockPriceDto addStockDto);
	public List<String> fetchAllCompanyNames();
	
}
