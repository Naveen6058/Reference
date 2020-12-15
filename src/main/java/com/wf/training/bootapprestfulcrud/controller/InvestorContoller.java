package com.wf.training.bootapprestfulcrud.controller;


//import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wf.training.bootapprestfulcrud.dto.CompanyHistoricalDataOutputDto;
import com.wf.training.bootapprestfulcrud.dto.LoginDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCommodityDto;
import com.wf.training.bootapprestfulcrud.dto.CommodityDto;
import com.wf.training.bootapprestfulcrud.dto.CompanyDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyDto;
import com.wf.training.bootapprestfulcrud.service.CommodityService;
import com.wf.training.bootapprestfulcrud.service.CompanyHistoricalDataService;
import com.wf.training.bootapprestfulcrud.service.CompanyService;
import com.wf.training.bootapprestfulcrud.service.InvestorService;

@Controller
@SessionAttributes("Investor")
@RequestMapping("/user")
public class InvestorContoller {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompanyHistoricalDataService historicalService;
	@Autowired
	private InvestorService investorService;
	@Autowired
	private CommodityService commodityService;

	//dashboard for user
	@RequestMapping(value= {"/home","/dashboard","/index"})
//	public String home(Principal principal) {
	public String home(@SessionAttribute("Investor") LoginDto investorLoginDto, Model model) {
		model.addAttribute("Investor", investorLoginDto);
		return "invHomePage";
	}
	
	@RequestMapping()
	public String defaultResponse() {
		// return "user-base";
		return "redirect:/user/home";
	}
	
	@RequestMapping("/profile-entry")
	public String profileEntry(Model model) {
		return "employee-profile-entry";
	}
	
	
	@RequestMapping("/wallet")
	public String wallet() {
		
		return "invWallet";
	}
	
	@RequestMapping("/searchCompany")
	public String company(@ModelAttribute("company") SearchCompanyDto company) {
		return "invSearchCompany";
	}
	
	@RequestMapping("/searchCommodity")
	public String commodity(@ModelAttribute("commodity") SearchCommodityDto commodity) {
		return "invSearchCommodity";
	}
	
	@RequestMapping("/searchCompanyName")
	public String searchCompanyName(@Valid @ModelAttribute("company") SearchCompanyDto company, BindingResult result, Model model,
			@SessionAttribute("Investor") LoginDto investorLoginDto) {
		if(result.hasErrors()) {
			return "invSearchCompany";
		}
		CompanyDto searchCompany = this.companyService.fetchSingleCompanyByName(company);
		this.investorService.addRecentViewCompany(investorLoginDto, searchCompany);
		
		model.addAttribute("searchCompany",searchCompany);
		return "invCompanyPage";
	}
	
	@RequestMapping("/commodity")
	public String searchCommodityName(@Valid @ModelAttribute("commodityName") SearchCommodityDto searchCommodityDto, BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			return "invSearchCommodity";
		}
		
		CommodityDto commodityDto = this.commodityService.fetchSingleCommodityByName(searchCommodityDto);
		
		model.addAttribute("commodityDto",commodityDto);
		return "invCommodityPage";
	}
	
	@RequestMapping("/company/{companyTitle}")
	public String searchCompanyByName(@PathVariable("companyTitle") String companyTitle, Model model,
			@SessionAttribute("Investor") LoginDto investorLoginDto) {

		CompanyDto searchCompany = this.companyService.fetchSingleCompanyByName(companyTitle);
		this.investorService.addRecentViewCompany(investorLoginDto, searchCompany);
		
		model.addAttribute("searchCompany",searchCompany);
		return "invCompanyPage";
	}
	
	@RequestMapping("/{companyTitle}/historicalPrices/{companyCode}")
	public String companyHistoricalPrice(@PathVariable Long companyCode, Model model) {
		List<CompanyHistoricalDataOutputDto> companyHistoricalDataOutputDto = 
				this.historicalService.fetchSingleByCompanyId(companyCode);
		
		model.addAttribute("companyHistoricalDataOutputDto", companyHistoricalDataOutputDto);
		return "invCompHistoricalPrices"; 
	}
	
	@RequestMapping("/recentViewCompanies")
	public String recentViewCompanies(@SessionAttribute("Investor") LoginDto investorLoginDto,Model model) {
		
		List<CompanyDto> companyDto = this.investorService.getAllRecentViewCompanies(investorLoginDto.getLoginKey());
		
		model.addAttribute("recentViewCompanies", companyDto);
		
		return "invRecentViewCompanies";
	}







}
