package com.wf.training.bootapprestfulcrud.controller;


import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapprestfulcrud.dto.CompanyHistoricalDataOutputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyInputDto;
import com.wf.training.bootapprestfulcrud.dto.SearchCompanyOutputDto;
import com.wf.training.bootapprestfulcrud.exception.EmployeeException;
import com.wf.training.bootapprestfulcrud.service.CompanyHistoricalDataService;
import com.wf.training.bootapprestfulcrud.service.CompanyService;

@Controller
@RequestMapping("/user")
public class UserContoller {

	//dashboard for user
	@RequestMapping(value= {"/home","/dashboard","/index"})  // /employee/home
	public String home(Principal principal) {
		// business logic
		
		return "UserHomePage";
	}
	
	// default mapping for parent url
	@RequestMapping()
	public String defaultResponse() {
		// return "user-base";
		return "redirect:/user/home";// ~sendRedirect()
	}
	
	// respond back profile-entry form
	@RequestMapping("/profile-entry") // /employee/profile-entry
	public String profileEntry(Model model) {
//		// share a blank/empty employee object with jsp to map with spring form
//		User user = new User();
//		user.setCountry("IN");
//		String[] languages = new String[] {"Python","C#"};
//		employee.setFavoriteLanguages(languages);
//		model.addAttribute("employee", employee);
		return "employee-profile-entry";
	}
	
	// auto add param value to model container
	// we want to validation : @Valid
//	@PostMapping("/profile-save")
//	public String saveProfile(@Valid @ModelAttribute Employee employee, 
//							  BindingResult result) {
//		if(result.hasErrors()) {
//			// revert back the entry form
//			return "employee-profile-entry";
//		}
//		
//		return "profile-confirm";
//	}
	
	
//	// @RequestMapping(value = { "/profile-save" }, method = RequestMethod.GET)
//	@GetMapping("/profile-save")
//	public String saveProfilePro(String name, String email, String contact) {
//		System.out.println("GET DATA : " + name + " | " + email + " | " + contact);
//		return "profile-confirm";
//	}
	
	@RequestMapping("/wallet")
	public String wallet(Principal principal) {
		// business logic
		
		return "Wallet";
	}
	
	@RequestMapping("/searchCompany")
	public String company(Model model) {
		SearchCompanyInputDto company = new SearchCompanyInputDto();
		model.addAttribute("company", company);
		return "SearchCompany";
	}
	
	@Autowired
	private CompanyService service;
	@Autowired
	private CompanyHistoricalDataService historicalService;
	
	@PostMapping("/searchCompanyName")
	public String searchCompanyName(@Valid @ModelAttribute SearchCompanyInputDto company, Model model, BindingResult result) {
		if(result.hasErrors()) {
			throw new EmployeeException("Invalid data format!");
		}
		SearchCompanyOutputDto searchCompany = this.service.fetchSingleCompany(Long.parseLong(company.getCompanyName()));
		
		model.addAttribute("searchCompany",searchCompany);
		return "Company";
	}
	
	@RequestMapping("/historicalPrices")
	public String companyHistoricalPrice(@ModelAttribute SearchCompanyOutputDto searchCompany, Model model) {
		
		List<CompanyHistoricalDataOutputDto> companyHistoricalDataOutputDto = 
				this.historicalService.fetchAllCompanies();
		
		model.addAttribute("companyHistoricalDataOutputDto", companyHistoricalDataOutputDto);
		model.addAttribute("searchCompany", searchCompany);
		return "company-historicalPrices"; 
	}
	












}
