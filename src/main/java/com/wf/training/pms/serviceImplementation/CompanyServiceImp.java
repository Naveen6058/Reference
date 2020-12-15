package com.wf.training.pms.serviceImplementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.pms.dto.StockPriceDto;
import com.wf.training.pms.dto.CompanyDto;
import com.wf.training.pms.dto.SearchCompanyDto;
import com.wf.training.pms.entity.Company;
import com.wf.training.pms.entity.HistoricalRecordCompany;
import com.wf.training.pms.repository.CompanyHistoricalDataRepository;
import com.wf.training.pms.repository.CompanyRepository;
import com.wf.training.pms.service.CompanyService;
@Service
public class CompanyServiceImp implements CompanyService {
	
	// inject repository as dependency
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyHistoricalDataRepository histRepo;
	
	private Company convertInputAddCompanyToEntity(CompanyDto addCompanyInputDto) {
		 Company company = new Company();
		 
		 company.setCompanyTitle(addCompanyInputDto.getCompanyTitle());
		 company.setOperation(addCompanyInputDto.getOperation());
		 company.setShareCount(addCompanyInputDto.getShareCount());
		 company.setSharePrice(addCompanyInputDto.getSharePrice());
		 company.setSector(addCompanyInputDto.getSector());
		 company.setCurrency(addCompanyInputDto.getCurrency());
		 company.setTurnover(addCompanyInputDto.getTurnover());
		 company.setDateTimeIPO(addCompanyInputDto.getDateTimeIPO());
		 company.setStockExchange(addCompanyInputDto.getStockExchange());
		 company.setIpoPrice(addCompanyInputDto.getIpoPrice());
		 
		 return company;
	}
	
	public CompanyDto convertCompanyEntityToOutputDto(Company company) {
		CompanyDto companyOutputCompany = new CompanyDto();
		
		companyOutputCompany.setCompanyCode(company.getCompanyCode());
		companyOutputCompany.setCompanyTitle(company.getCompanyTitle());
		companyOutputCompany.setOperation(company.getOperation());
		companyOutputCompany.setShareCount(company.getShareCount());
		companyOutputCompany.setSharePrice(company.getSharePrice());
		companyOutputCompany.setSector(company.getSector());
		companyOutputCompany.setCurrency(company.getCurrency());
		companyOutputCompany.setTurnover(company.getTurnover());
		companyOutputCompany.setDateTimeIPO(company.getDateTimeIPO());
		companyOutputCompany.setStockExchange(company.getStockExchange());
		companyOutputCompany.setIpoPrice(company.getIpoPrice());
		 
		return companyOutputCompany;
	}
	
	private Company convertCompanyOutputToEntity(CompanyDto companyOutputDto) {
		Company company = new Company();
		
		company.setCompanyCode(companyOutputDto.getCompanyCode());
		company.setCompanyCode(companyOutputDto.getCompanyCode());
		company.setCompanyTitle(companyOutputDto.getCompanyTitle());
		company.setOperation(companyOutputDto.getOperation());
		company.setShareCount(companyOutputDto.getShareCount());
		company.setSharePrice(companyOutputDto.getSharePrice());
		company.setSector(companyOutputDto.getSector());
		company.setCurrency(companyOutputDto.getCurrency());
		company.setTurnover(companyOutputDto.getTurnover());
		company.setDateTimeIPO(companyOutputDto.getDateTimeIPO());
		company.setStockExchange(companyOutputDto.getStockExchange());
		company.setIpoPrice(companyOutputDto.getIpoPrice());
		 
		return company;
	}
	
	private Company convertSearchCompanyDtoToEntity(SearchCompanyDto searchCompanyDto) {
		Company company = new Company();
		
		company.setCompanyTitle(searchCompanyDto.getCompanyName());
		
		return company;
	}

	@Override
	public List<CompanyDto> fetchAllCompanies() {
		List<Company> company=this.companyRepository.findAll();
		List<CompanyDto> dto=new ArrayList<CompanyDto>();
		for(Company c:company)
			dto.add(this.convertCompanyEntityToOutputDto(c));
		return dto;
	}
	
	@Override
	public List<String> fetchAllCompanyNames() {
		List<CompanyDto> companyList=this.fetchAllCompanies();
		List<String> companyNames=new ArrayList<String>();
		for(CompanyDto c:companyList)
		 companyNames.add(c.getCompanyTitle());
		
		return companyNames;
	}

	@Override
	public CompanyDto fetchSingleCompany(Long id) {
		// fetch record from DB
		Company company = this.companyRepository.findById(id).orElse(null);
		// convert entity into output dto
		CompanyDto companyOutputDto =  this.convertCompanyEntityToOutputDto(company);
		return companyOutputDto;
	}
	
	@Override
	public CompanyDto fetchSingleCompanyByName(SearchCompanyDto searchCompanyDto) {
		Company company = this.convertSearchCompanyDtoToEntity(searchCompanyDto);
		
		// fetch record from DB
		Company newcompany = this.companyRepository.findBycompanyTitle(company.getCompanyTitle()).orElseThrow(()->new NullPointerException());
		// convert entity into output dto
		CompanyDto companyOutputDto =  this.convertCompanyEntityToOutputDto(newcompany);
		return companyOutputDto;
	}

	@Override
	public CompanyDto addCompany(CompanyDto addCompanyInputDto) {
		CompanyDto addCompanyOutputDto = new CompanyDto();
		
		Company company =  this.convertInputAddCompanyToEntity(addCompanyInputDto);
		Company newCompany = this.companyRepository.save(company);
		addCompanyOutputDto = this.convertCompanyEntityToOutputDto(newCompany);
		
		return addCompanyOutputDto;
	}

	@Override
	public CompanyDto editCompany(Long id, SearchCompanyDto employeeInputDto) {
		return null;
	}
	
	@Override
	public CompanyDto modifyCompany(CompanyDto companyOutputDto) {
		Company company = this.convertCompanyOutputToEntity(companyOutputDto);
		Company modifyCompany = this.companyRepository.save(company);
		
		CompanyDto companyNewOutputDto = this.convertCompanyEntityToOutputDto(modifyCompany);
		
		return companyNewOutputDto;
	}

	@Override
	public CompanyDto deleteCompany(Long id) {
		return null;
	}

	@Override
	public boolean addStockPrice(StockPriceDto addStockDto) {
		Company company=this.companyRepository.findBycompanyTitle(addStockDto.getCompanyName()).orElse(null);
		if(company!=null) {
		HistoricalRecordCompany entity=new HistoricalRecordCompany();
		entity.setCompanyCode(company.getCompanyCode());
		entity.setCurrency(company.getCurrency());
		entity.setStockPrice(addStockDto.getSharePrice());
		entity.setDateTime(LocalDateTime.now().toString());
		this.histRepo.save(entity);
		//add statement to update price in company table
		return true;
		}
		
		return false;
	}

	@Override
	public CompanyDto fetchSingleCompanyByName(String companyTitle) {
		Company company = this.companyRepository.findBycompanyTitle(companyTitle).orElse(null);
		CompanyDto companyDto = this.convertCompanyEntityToOutputDto(company);
		return companyDto;
	}

}
