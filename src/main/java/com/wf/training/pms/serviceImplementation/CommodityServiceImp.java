package com.wf.training.pms.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.pms.dto.CommodityDto;
import com.wf.training.pms.dto.SearchCommodityDto;
import com.wf.training.pms.entity.Commodity;
import com.wf.training.pms.repository.CommodityRepository;
import com.wf.training.pms.service.CommodityService;

@Service
public class CommodityServiceImp implements CommodityService {
	
	@Autowired
	private CommodityRepository commodityRepository;
	
	private Commodity convertInputAddCommodityToEntity(CommodityDto dto) {
		Commodity com = new Commodity();
		 
		//com.setCommodityId(dto.getCommodityId());
		com.setCommodityName(dto.getCommodityName());
		com.setCurrency(dto.getCurrency());
		com.setPrice(dto.getPrice());
		com.setDateTime(dto.getDateTime());
		//com.setBoUserId(boUserId);
		 
		 return com;
	}
	
	private CommodityDto convertCommodityEntityToOutputDto(Commodity newCom) {
		CommodityDto outputDto = new CommodityDto();
		
		outputDto.setCommodityId(newCom.getCommodityId());
		outputDto.setCommodityName(newCom.getCommodityName());
		outputDto.setCurrency(newCom.getCurrency());
		outputDto.setPrice(newCom.getPrice());
		outputDto.setBoUserId(newCom.getBoUserId());
		 
		return outputDto;
	}
//	
//
//	@Override
//	public List<CompanyDto> fetchAllCompanies() {
//		return null;
//	}
//
//	@Override
//	public CompanyDto fetchSingleCompany(Long id) {
//		// fetch record from DB
//		Company company = this.companyRepository.findById(id).orElse(null);
//		// convert entity into output dto
//		CompanyDto companyOutputDto =  this.convertCompanyEntityToOutputDto(company);
//		return companyOutputDto;
//	}

//
//	@Override
//	public CompanyDto editCompany(Long id, SearchCompanyDto employeeInputDto) {
//		return null;
//	}
//	


	@Override
	public CommodityDto addCommodity(CommodityDto dto) {
				
		Commodity com =  this.convertInputAddCommodityToEntity(dto);
		Commodity newCom = this.commodityRepository.save(com);
		
		return this.convertCommodityEntityToOutputDto(newCom);
	}

	@Override
	public CommodityDto fetchSingleCommodityByName(SearchCommodityDto searchCommodityDto) {
		Commodity commodity = this.convertSearchCommodityDtoToEntity(searchCommodityDto);
		
		Commodity newCommodity = this.commodityRepository.findByCommodityName(commodity.getCommodityName());
		CommodityDto commodityOutputDto =  this.convertCommodityEntityToOutputDto(newCommodity);
		return commodityOutputDto;
	}

	private Commodity convertSearchCommodityDtoToEntity(SearchCommodityDto searchCommodityDto) {
		Commodity commodity = new Commodity();
		
		commodity.setCommodityName(searchCommodityDto.getCommodityName());
		
		return commodity;
	}

	@Override
	public CommodityDto modifyCommodity(CommodityDto commodityNewOutputDto) {
		Commodity commodity = this.convertCommodityOutputToEntity(commodityNewOutputDto);
		Commodity modifyCommodity = this.commodityRepository.save(commodity);
		
		CommodityDto dto = this.convertCommodityEntityToOutputDto(modifyCommodity);
	
		return dto;
	}

	private Commodity convertCommodityOutputToEntity(CommodityDto commodityNewOutputDto) {
		Commodity commodity = new Commodity();
		
		commodity.setCommodityId(commodityNewOutputDto.getCommodityId());
		commodity.setCommodityName(commodityNewOutputDto.getCommodityName());
		commodity.setCurrency(commodityNewOutputDto.getCurrency());
		commodity.setDateTime(commodityNewOutputDto.getDateTime());
		commodity.setPrice(commodityNewOutputDto.getPrice());
		return commodity;
	}

	@Override
	public CommodityDto fetchSingleCommodityByName(String commodityName) {
		
		Commodity commodity = this.commodityRepository.findByCommodityName(commodityName);
		CommodityDto commodityDto = this.convertCommodityEntityToOutputDto(commodity);
		return commodityDto;
	}

	
}
