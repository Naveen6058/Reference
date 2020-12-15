package com.wf.training.bootapprestfulcrud.service;

import java.util.List;

import javax.validation.Valid;

import com.wf.training.bootapprestfulcrud.dto.AddStockPriceDto;
import com.wf.training.bootapprestfulcrud.dto.CompanyDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyDto;


public interface CompanyService {

	public List<CompanyDto> fetchAllCompanies();
	public CompanyDto fetchSingleCompany(Long id);
	public CompanyDto addCompany(CompanyDto addCompanyInputDto);
	public CompanyDto editCompany(Long id, SearchCompanyDto employeeInputDto);
	public CompanyDto deleteCompany(Long id);
	public CompanyDto fetchSingleCompanyByName(SearchCompanyDto searchCompanyDto);
	public CompanyDto fetchSingleCompanyByName(String companyTitle);
	public CompanyDto modifyCompany(CompanyDto companyOutputDto);
	public boolean addStockPrice(AddStockPriceDto addStockDto);
	public List<String> fetchAllCompanyNames();
	
}
