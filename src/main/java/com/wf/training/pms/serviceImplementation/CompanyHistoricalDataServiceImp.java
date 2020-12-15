package com.wf.training.pms.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.pms.dto.CompanyHistoricalDataOutputDto;
import com.wf.training.pms.entity.Company;
import com.wf.training.pms.entity.HistoricalRecordCompany;
import com.wf.training.pms.repository.CompanyHistoricalDataRepository;
import com.wf.training.pms.repository.CompanyRepository;
import com.wf.training.pms.service.CompanyHistoricalDataService;

@Service
public class CompanyHistoricalDataServiceImp implements CompanyHistoricalDataService {

	@Autowired
	private CompanyHistoricalDataRepository CompanyHistoricalDataRepository;

	@Autowired
	private CompanyRepository CompanyRepository;

	@Override
	public List<CompanyHistoricalDataOutputDto> fetchAllCompanies() {
		// To do
		return null;
	}

	@Override
	public List<CompanyHistoricalDataOutputDto> fetchSingleByCompanyId(Long companyCode) {
		List<HistoricalRecordCompany> historicalPriceData = this.CompanyHistoricalDataRepository
				.findAllByCompanyCode(companyCode).orElse(null);
		Company company = this.CompanyRepository.findById(companyCode).orElse(null);

		if (historicalPriceData == null) {
			return null;
		}
		List<CompanyHistoricalDataOutputDto> historicalPrices = this.convertEntityToOutputDto(historicalPriceData,
				company);
		return historicalPrices;
	}

	private List<CompanyHistoricalDataOutputDto> convertEntityToOutputDto(
			List<HistoricalRecordCompany> historicalRecordCompany, Company company) {

		List<CompanyHistoricalDataOutputDto> companyHistoricalDataOutputDto = new ArrayList<CompanyHistoricalDataOutputDto>();

		for (HistoricalRecordCompany historicalPrice : historicalRecordCompany) {
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

}
