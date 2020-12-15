package com.wf.training.bootapprestfulcrud.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wf.training.bootapprestfulcrud.dto.BackOfficeLoginDto;
import com.wf.training.bootapprestfulcrud.dto.SuperUserLoginDto;
import com.wf.training.bootapprestfulcrud.dto.InvestorDto;
import com.wf.training.bootapprestfulcrud.dto.LoginDto;
import com.wf.training.bootapprestfulcrud.service.BackOfficeUserService;
import com.wf.training.bootapprestfulcrud.service.InvestorService;
import com.wf.training.bootapprestfulcrud.service.SuperUserService;

@Controller
@SessionAttributes("Investor")
public class HomeController {
	
	@Autowired
	private SuperUserService superService;
	
	@Autowired
	private BackOfficeUserService boService;
	
	@Autowired
	private InvestorService investorService;
	
	@RequestMapping(value ={"/logout","/index",""})
	public String logout() {
		return "index";
	}
	
	@RequestMapping("/InvestorLogin")
	public String userLogin(@ModelAttribute("investorLoginDto") LoginDto investorLoginDto) {
		return "invLogin";
	}
	
	
	@RequestMapping("/SuperUserLogin")
	public String superUserLogin(Model model) {
		SuperUserLoginDto superuser = new SuperUserLoginDto();
		model.addAttribute("superuser", superuser);
		return "SuperUserLogin";
	}
	
	@RequestMapping("/BOUserLogin")
	public String backOfficeUserLogin(Model model) {
		BackOfficeLoginDto backofficeuser=new BackOfficeLoginDto();
		model.addAttribute("backofficeuser", backofficeuser);
		return "BackOfficeUserLogin";
	}
	
	@PostMapping("/validate")
	public String loginValidate(@Valid @ModelAttribute("superuser") SuperUserLoginDto dto,BindingResult result,Model model) {
		System.out.println("Logging in");
		if(result.hasErrors()) {
			return "SuperUserLogin";
		} 
		//else if(superuser.getSuperUserId().equals(1) && superuser.getPassword().equals("abc")) {
		else if(superService.validateUser(dto)) {
			System.out.println("superuser");
			return "SuperUserHomePage";
		}else
			model.addAttribute("Message", "Invalid Credentials");
			return "SuperUserLogin";
	}
	
	@PostMapping("/bovalidate")
	public String boLoginValidate(@Valid @ModelAttribute("backofficeuser") BackOfficeLoginDto user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "BackOfficeUserLogin";
		}
		else if(boService.validateUser(user)) {
				return "BackOfficeUserHomePage";
			}else {
				model.addAttribute("Message", "Invalid Credentials");
			return "BackOfficeUserLogin";
			}
	}
	
	@RequestMapping("/InvestorRegistration")
	public String userRegistration(@ModelAttribute("newInvestor") InvestorDto newInvestor) {
		return "invRegistration";
	}
	
	@RequestMapping("/createInvestor")
	public String createInvestor(@Valid @ModelAttribute("newInvestor") InvestorDto newInvestor, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "invRegistration";
		}
		InvestorDto newInvestorOut = this.investorService.addInvestor(newInvestor);
		
		if(newInvestorOut==null) {
			model.addAttribute("Message", "Investor already registered");
			return "invRegistration";
		}
		
		model.addAttribute("newInvestorOut", newInvestorOut);
		
		return "SavedInvestor";
	}
	
	@RequestMapping("/invValidate")
	public String invValidate(@Valid @ModelAttribute("investorLoginDto") LoginDto investorLoginDto, BindingResult result, Model model,
			HttpServletRequest request, HttpSession session) {
		if (result.hasErrors()) {
			return "invLogin";
		}
		
		session.invalidate();
	    HttpSession newSession = request.getSession();
		
		boolean status = this.investorService.validateInvestor(investorLoginDto);
		newSession.setAttribute("Investor", investorLoginDto);
		if (status==true) {
			return "invHomePage";
		}else {
			model.addAttribute("Message", "Invalid Credentials");
			return "invLogin";
		}
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
		return "error-page";
	}
	
	@RequestMapping("/custom-login")
	public String customLogin() {
		return "custom-login";
	}
	
}
