package com.wf.training.bootapprestfulcrud.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.CompanyHistoricalDataOutputDto;
import com.wf.training.bootapprestfulcrud.entity.Company;
import com.wf.training.bootapprestfulcrud.entity.HistoricalRecordCompany;
import com.wf.training.bootapprestfulcrud.repository.CompanyHistoricalDataRepository;
import com.wf.training.bootapprestfulcrud.repository.CompanyRepository;
import com.wf.training.bootapprestfulcrud.service.CompanyHistoricalDataService;

@Service
public class CompanyHistoricalDataServiceImp implements CompanyHistoricalDataService {

	// inject repository as dependency
	@Autowired
	private CompanyHistoricalDataRepository companyHPRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	// utility method
	private List<CompanyHistoricalDataOutputDto> convertEntityToOutputDto(List<HistoricalRecordCompany> historicalRecordCompany,Company company) {
		
		List<CompanyHistoricalDataOutputDto> companyHistoricalDataOutputDto = new ArrayList<CompanyHistoricalDataOutputDto>();
		
		for(HistoricalRecordCompany historicalPrice:historicalRecordCompany) {
			CompanyHistoricalDataOutputDto listPrice = new CompanyHistoricalDataOutputDto();
			
			listPrice.setCompanyCode(company.getCompanyCode());
			listPrice.setCompanyName(company.getCompanyTitle());
			listPrice.setCurrency(historicalPrice.getCurrency());
			listPrice.setDateTime(historicalPrice.getDateTime());
			listPrice.setStockPrice(historicalPrice.getStockPrice());
			companyHistoricalDataOutputDto.add(listPrice);
		}
		
		return companyHistoricalDataOutputDto;
	}
	
	@Override
	public List<CompanyHistoricalDataOutputDto> fetchAllCompanies() {
//		// use repository to fetch data from DB
//		List<HistoricalRecordCompany> historicalRecordCompany = this.companyHPRepository.findAll();
//		List<CompanyHistoricalDataOutputDto> companyHistoricalDataOutputDto = 
//				this.convertEntityToOutputDto(historicalPriceData, company);
//		return companyHistoricalDataOutputDto;
		return null;
	}

	@Override
	public List<CompanyHistoricalDataOutputDto> fetchSingleByCompanyId(Long companyCode) {
		List<HistoricalRecordCompany> historicalPriceData = this.companyHPRepository.findAllByCompanyCode(companyCode).orElse(null);
		Company company = this.companyRepository.findById(companyCode).orElse(null);
		
		if(historicalPriceData==null) {
			return null;
		}
		
		List<CompanyHistoricalDataOutputDto> historicalPrices = this.convertEntityToOutputDto(historicalPriceData, company);
		
		return historicalPrices;
	}

}
