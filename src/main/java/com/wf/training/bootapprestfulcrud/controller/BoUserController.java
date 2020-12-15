package com.wf.training.bootapprestfulcrud.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapprestfulcrud.dto.AddStockPriceDto;
import com.wf.training.bootapprestfulcrud.dto.BackOfficeLoginDto;
import com.wf.training.bootapprestfulcrud.dto.CommodityDto;
import com.wf.training.bootapprestfulcrud.dto.CompanyDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCommodityDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyDto;
import com.wf.training.bootapprestfulcrud.service.CommodityService;
import com.wf.training.bootapprestfulcrud.service.CompanyService;

@Controller
@RequestMapping("/bouser")
public class BoUserController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping("/home")
	public String returnHome() {
		// add business logic
		
		// respond back with a view page name
		return "BackOfficeUserHomePage";
	}

	@RequestMapping("/validate")
	public String loginValidate() {
		// add business logic
		
		// respond back with a view page name
		return "index";
	}
	
	@RequestMapping("/returnAddCompany")
	public String returnAddCompany(@ModelAttribute("createCompany") CompanyDto createCompany) {
		// add business logic
		
		
		// respond back with a view page name
		return "CreateCompany";
	}
	
	@PostMapping("/createCompany")
	public String addCompany(@Valid @ModelAttribute("createCompany") CompanyDto createCompany,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "CreateCompany";
		}
		
		CompanyDto addCompanyOutputDto = this.companyService.addCompany(createCompany);
		
		model.addAttribute("CompanyOutput", addCompanyOutputDto);
		// respond back with a view page name
		return "SavedCompany";
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
		// respond back with a view page name
		return "ModifyCompany";
	}
	
	@RequestMapping("/modifyCompany")
	public String modifyCompany(@Valid @ModelAttribute("companyNewOutputDto") CompanyDto companyNewOutputDto, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "ModifyCompany";
		}
		
		CompanyDto companyOutputDto =this.companyService.modifyCompany(companyNewOutputDto);
		model .addAttribute("CompanyOutput", companyOutputDto);
		
		// respond back with a view page name
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
		// respond back with a view page name
		return "ModifyCommodity";
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
	public String addCompanyStockPrice(@ModelAttribute("addstockprice") AddStockPriceDto addStockDto,Model model) {
//		 List<CompanyDto> companyList=this.companyService.fetchAllCompanies();
//		 List<String> companyNames=new ArrayList<String>();
//		for(CompanyDto c:companyList)
//		 companyNames.add(c.getCompanyTitle());
		List<String> companyNames=this.companyService.fetchAllCompanyNames();
		model.addAttribute("companyNames",companyNames);
		return "BoAddCompanyStockPrice";
	}
	
	//@ModelAttribute("companyNames")
	@PostMapping("/newStockPrice")
	public String newStockPrice(@Valid @ModelAttribute("addstockprice") AddStockPriceDto addStockDto,BindingResult result,Model model) {
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
	
	@RequestMapping("/addCommodityPrice")
	public String addCommodityPrice(@ModelAttribute("selectCompany") SearchCompanyDto searchCompanyDto) {
		return "SelectModifyCompany";
	}
}
