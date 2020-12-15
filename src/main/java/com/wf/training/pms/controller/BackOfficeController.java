package com.wf.training.pms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;



import com.wf.training.pms.dto.StockPriceDto;
import com.wf.training.pms.dto.CommodityDto;
import com.wf.training.pms.dto.CompanyDto;
import com.wf.training.pms.dto.SearchCommodityDto;
import com.wf.training.pms.dto.SearchCompanyDto;
import com.wf.training.pms.service.CommodityService;
import com.wf.training.pms.service.CompanyService;

@Controller
@RequestMapping("/bouser")
public class BackOfficeController {
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/home")
	public String returnHome() {
		
		return "BackOfficeUserHomePage";
	}
	
	
	@RequestMapping("/selectModifyCommodity")
	public String selectModifyCommodity(@ModelAttribute("selectCommodity") SearchCommodityDto searchCommodityDto) {
		return "SelectModifyCommodity";
	}
	
	@RequestMapping("/returnModifyCommodity")
	public String returnModifyCommodity(@Valid @ModelAttribute("selectCommodity") SearchCommodityDto searchCommodityDto, BindingResult result, @ModelAttribute("comDto") CommodityDto comDto, Model model) {
		if (result.hasErrors()) {
			return "SelectModifyCommodity";
		}
		CommodityDto output = new CommodityDto();
		
		output = this.commodityService.fetchSingleCommodityByName(searchCommodityDto);
		comDto.setDateTime(LocalDateTime.now().toString());
		model.addAttribute("searchCommodityDto", output);
		
		return "ModifyCommodity";
	}

	@RequestMapping("/validate")
	public String loginValidate() {
		
		return "index";
	}
	
	@RequestMapping("/returnAddCompany")
	public String returnAddCompany(@ModelAttribute("createCompany") CompanyDto createCompany) {
		
		return "CreateCompany";
	}
	
	@PostMapping("/createCompany")
	public String addCompany(@Valid @ModelAttribute("createCompany") CompanyDto createCompany,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "CreateCompany";
		}
		
		CompanyDto addCompanyOutputDto = this.companyService.addCompany(createCompany);
		
		model.addAttribute("CompanyOutput", addCompanyOutputDto);
		
		return "SavedCompany";
	}
	
	
	
	@RequestMapping("/modifyCompany")
	public String modifyCompany(@Valid @ModelAttribute("companyNewOutputDto") CompanyDto companyNewOutputDto, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "ModifyCompany";
		}
		
		CompanyDto companyOutputDto =this.companyService.modifyCompany(companyNewOutputDto);
		model .addAttribute("CompanyOutput", companyOutputDto);
		
		
		return "SavedCompany";
	}
	
	
	@RequestMapping("/returnCreateCommodity")
	public String returnAddCommodity(Model model ) {
		CommodityDto commodityDto=new CommodityDto();
		commodityDto.setDateTime(LocalDateTime.now().toString());
		model.addAttribute("commodity", commodityDto);
		
		return "CreateCommodity";
	}
	
	@PostMapping("/createCommodity")
	public String addCommodity(@Valid @ModelAttribute("commodity") CommodityDto dto,BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "CreateCommodity";
		}
		CommodityDto output=this.commodityService.addCommodity(dto);
		model.addAttribute("CommodityOutput", output);
		return "SavedCommodity";
	}
	
	
	
	@RequestMapping("/modifyCommodity")
	public String modifyCommodity(@Valid @ModelAttribute("commodityNewOutputDto") CommodityDto commodityNewOutputDto, BindingResult result, Model model) {
		System.out.println("modifyCommodity");
		System.out.println(commodityNewOutputDto);
		System.out.println("modifyCommodity");
		
		if (result.hasErrors()) {
			return "ModifyCommodity";
		}
		
		CommodityDto commodityOutputDto =this.commodityService.modifyCommodity(commodityNewOutputDto);
		model .addAttribute("CommodityOutput", commodityOutputDto);
		System.out.println("modifyCommodity1");
		System.out.println(commodityOutputDto);
		System.out.println("modifyCommodity1");
		
		return "SavedCommodity";
	}
	
	@RequestMapping("/addCompanyStockPrice")
	public String addCompanyStockPrice(@ModelAttribute("addstockprice") StockPriceDto addStockDto,Model model) {

		List<String> companyNames=this.companyService.fetchAllCompanyNames();
		model.addAttribute("companyNames",companyNames);
		return "BoAddCompanyStockPrice";
	}
	
	
	@PostMapping("/newStockPrice")
	public String newStockPrice(@Valid @ModelAttribute("addstockprice") StockPriceDto addStockDto,BindingResult result,Model model) {
		List<String> companyNames=this.companyService.fetchAllCompanyNames();
		model.addAttribute("companyNames",companyNames);
		if (result.hasErrors()) {
			
			return "BoAddCompanyStockPrice";
		}
		if(this.companyService.addStockPrice(addStockDto))
		{
			model.addAttribute("Message", "Stock added successfully");
			return "BoAddCompanyStockPrice";
		}
		return "BoAddCompanyStockPrice";
	}
	@RequestMapping("/selectModifyCompany")
	public String selectModifyCompany(@ModelAttribute("selectCompany") SearchCompanyDto searchCompanyDto) {
		return "SelectModifyCompany";
	}
	
	@RequestMapping("/returnModifyCompany")
	public String returnModifyCompany(@Valid @ModelAttribute("selectCompany") SearchCompanyDto searchCompanyDto, BindingResult result, @ModelAttribute("companyNewOutputDto") CompanyDto companyNewOutputDto, Model model) {
		if (result.hasErrors()) {
			return "SelectModifyCompany";
		}
		CompanyDto companyOutputDto = new CompanyDto();
		
		companyOutputDto = this.companyService.fetchSingleCompanyByName(searchCompanyDto);
		model.addAttribute("searchCompanyDto", companyOutputDto);
		
		return "ModifyCompany";
	}
	
	@RequestMapping("/addCommodityPrice")
	public String addCommodityPrice(@ModelAttribute("selectCompany") SearchCompanyDto searchCompanyDto) {
		return "SelectModifyCompany";
	}
}
