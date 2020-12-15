package com.wf.training.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.List;
import javax.validation.Valid;
import com.wf.training.pms.dto.CompanyHistoricalDataOutputDto;
import com.wf.training.pms.dto.LoginDto;
import com.wf.training.pms.dto.SearchCommodityDto;
import com.wf.training.pms.dto.CommodityDto;
import com.wf.training.pms.dto.CompanyDto;
import com.wf.training.pms.dto.SearchCompanyDto;
import com.wf.training.pms.service.CommodityService;
import com.wf.training.pms.service.CompanyHistoricalDataService;
import com.wf.training.pms.service.CompanyService;
import com.wf.training.pms.service.InvestorService;

@Controller
@SessionAttributes("Investor")
@RequestMapping("/user")
public class InvestorContoller {

	@Autowired
	private CompanyHistoricalDataService CompanyHistoricalDataService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private InvestorService investorService;

	@Autowired
	private CommodityService commodityService;

	@RequestMapping(value = { "/home", "/dashboard", "/index" })
	public String home(@SessionAttribute("Investor") LoginDto investorLoginDto, Model model) {
		model.addAttribute("Investor", investorLoginDto);
		return "invHomePage";
	}

	@RequestMapping("/searchCompany")
	public String company(@ModelAttribute("company") SearchCompanyDto company) {
		return "invSearchCompany";
	}

	@RequestMapping("/searchCommodity")
	public String commodity(@ModelAttribute("commodity") SearchCommodityDto commodity) {
		return "invSearchCommodity";
	}

	@RequestMapping("/{companyTitle}/historicalPrices/{companyCode}")
	public String companyHistoricalPrice(@PathVariable Long companyCode, Model model) {
		List<CompanyHistoricalDataOutputDto> companyHistoricalDataOutputDto = this.CompanyHistoricalDataService
				.fetchSingleByCompanyId(companyCode);

		model.addAttribute("companyHistoricalDataOutputDto", companyHistoricalDataOutputDto);
		return "invCompHistoricalPrices";
	}

	@RequestMapping("/searchCompanyName")
	public String searchCompanyName(@Valid @ModelAttribute("company") SearchCompanyDto company, BindingResult result,
			Model model, @SessionAttribute("Investor") LoginDto investorLoginDto) {
		if (result.hasErrors()) {
			return "invSearchCompany";
		}
		CompanyDto searchCompany = this.companyService.fetchSingleCompanyByName(company);
		this.investorService.addRecentViewCompany(investorLoginDto, searchCompany);

		model.addAttribute("searchCompany", searchCompany);
		return "invCompanyPage";
	}

	@RequestMapping("/commodity")
	public String searchCommodityName(@Valid @ModelAttribute("commodityName") SearchCommodityDto searchCommodityDto,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "invSearchCommodity";
		}

		CommodityDto commodityDto = this.commodityService.fetchSingleCommodityByName(searchCommodityDto);

		model.addAttribute("commodityDto", commodityDto);
		return "invCommodityPage";
	}

	@RequestMapping("/company/{companyTitle}")
	public String searchCompanyByName(@PathVariable("companyTitle") String companyTitle, Model model,
			@SessionAttribute("Investor") LoginDto investorLoginDto) {

		CompanyDto searchCompany = this.companyService.fetchSingleCompanyByName(companyTitle);
		this.investorService.addRecentViewCompany(investorLoginDto, searchCompany);

		model.addAttribute("searchCompany", searchCompany);
		return "invCompanyPage";
	}

	@RequestMapping()
	public String defaultResponse() {

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

	@RequestMapping("/recentViewCompanies")
	public String recentViewCompanies(@SessionAttribute("Investor") LoginDto investorLoginDto, Model model) {

		List<CompanyDto> companyDto = this.investorService.getAllRecentViewCompanies(investorLoginDto.getLoginKey());

		model.addAttribute("recentViewCompanies", companyDto);

		return "invRecentViewCompanies";
	}

}
