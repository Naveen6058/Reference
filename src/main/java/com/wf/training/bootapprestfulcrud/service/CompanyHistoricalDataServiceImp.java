package com.wf.training.bootapprestfulcrud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.CompanyHistoricalDataOutputDto;
import com.wf.training.bootapprestfulcrud.entity.HistoricalRecordCompany;
import com.wf.training.bootapprestfulcrud.repository.CompanyHistoricalDataRepository;

@Service
public class CompanyHistoricalDataServiceImp implements CompanyHistoricalDataService {

	// inject repository as dependency
	@Autowired
	private CompanyHistoricalDataRepository repository;
	
	// utility method
	private CompanyHistoricalDataOutputDto convertEntityToOutputDto(HistoricalRecordCompany historicalRecordCompany) {
		
		CompanyHistoricalDataOutputDto companyHistoricalDataOutputDto = new CompanyHistoricalDataOutputDto();
		
		companyHistoricalDataOutputDto.setCompanyCode(historicalRecordCompany.getCompanyCode());
		companyHistoricalDataOutputDto.setStockPrice(historicalRecordCompany.getStockPrice());
		companyHistoricalDataOutputDto.setDateTime(historicalRecordCompany.getDateTime());
		
		return companyHistoricalDataOutputDto;
	}
	
	@Override
	public List<CompanyHistoricalDataOutputDto> fetchAllCompanies() {
		// use repository to fetch data from DB
		List<HistoricalRecordCompany> historicalRecordCompany = this.repository.findAll();
		List<CompanyHistoricalDataOutputDto> companyHistoricalDataOutputDto = 
				historicalRecordCompany.stream()
							 .map(this :: convertEntityToOutputDto)
							 .collect(Collectors.toList());
		return companyHistoricalDataOutputDto;
	}

}
