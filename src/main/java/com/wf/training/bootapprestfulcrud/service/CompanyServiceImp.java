package com.wf.training.bootapprestfulcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.SearchCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyOutputDto;
import com.wf.training.bootapprestfulcrud.entity.Company;
import com.wf.training.bootapprestfulcrud.repository.CompanyRepository;
@Service
public class CompanyServiceImp implements CompanyService {
	
	// inject repository as dependency
	@Autowired
	private CompanyRepository repository;
	
	// utility method
	private SearchCompanyOutputDto convertEntityToOutputDto(Company company) {
		
		SearchCompanyOutputDto companyOutputDto = new SearchCompanyOutputDto();
		companyOutputDto.setCompanyCode(company.getCompanyCode());
		companyOutputDto.setCompanyTitle(company.getCompanyTitle());
		companyOutputDto.setOperation(company.getOperation());
		companyOutputDto.setShareCount(company.getShareCount());
		companyOutputDto.setSharePrice(company.getSharePrice());
		companyOutputDto.setSector(company.getSector());
		companyOutputDto.setCurrency(company.getCurrency());
		companyOutputDto.setTurnover(company.getTurnover());
		companyOutputDto.setDateTimeIPO(company.getDateTimeIPO());
		companyOutputDto.setStockExchange(company.getStockExchange());
		companyOutputDto.setIpoPrice(company.getIpoPrice());
		
		return companyOutputDto;
	}

	@Override
	public List<SearchCompanyOutputDto> fetchAllCompanies() {
		return null;
	}

	@Override
	public SearchCompanyOutputDto fetchSingleCompany(Long id) {
		// fetch record from DB
		Company company = this.repository.findById(id).orElse(null);
		// convert entity into output dto
		SearchCompanyOutputDto companyOutputDto =  this.convertEntityToOutputDto(company);
		return companyOutputDto;
	}

	@Override
	public SearchCompanyOutputDto addCompany(SearchCompanyInputDto employeeInputDto) {
		return null;
	}

	@Override
	public SearchCompanyOutputDto editCompany(Long id, SearchCompanyInputDto employeeInputDto) {
		return null;
	}

	@Override
	public SearchCompanyOutputDto deleteCompany(Long id) {
		return null;
	}

}
