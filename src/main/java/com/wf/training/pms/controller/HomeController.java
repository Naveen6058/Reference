package com.wf.training.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.wf.training.pms.dto.BackOfficeLoginDto;
import com.wf.training.pms.dto.AdminLoginDto;
import com.wf.training.pms.dto.InvestorDto;
import com.wf.training.pms.dto.LoginDto;
import com.wf.training.pms.service.BackOfficeUserService;
import com.wf.training.pms.service.InvestorService;
import com.wf.training.pms.service.AdminUserService;

@Controller
@SessionAttributes("Investor")
public class HomeController {

	@Autowired
	private BackOfficeUserService BackOfficeService;

	@Autowired
	private InvestorService investorService;
	
	@Autowired
	private AdminUserService adminService;

	@RequestMapping(value = { "/logout", "/index", "" })
	public String logout() {
		return "index";
	}

	@RequestMapping("/InvestorRegistration")
	public String userRegistration(@ModelAttribute("newInvestor") InvestorDto newInvestor) {
		return "invRegistration";
	}

	@PostMapping("/validate")
	public String loginValidate(@Valid @ModelAttribute("superuser") AdminLoginDto dto, BindingResult result,
			Model model) {
		System.out.println("Logging in");
		if (result.hasErrors()) {
			return "SuperUserLogin";
		} else if (adminService.validateUser(dto)) {
			System.out.println("superuser");
			return "SuperUserHomePage";
		} else
			model.addAttribute("Message", "Invalid Credentials");
		return "SuperUserLogin";
	}

	@RequestMapping("/createInvestor")
	public String createInvestor(@Valid @ModelAttribute("newInvestor") InvestorDto newInvestor, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "invRegistration";
		}
		InvestorDto newInvestorOut = this.investorService.addInvestor(newInvestor);

		if (newInvestorOut == null) {
			model.addAttribute("Message", "Investor already registered");
			return "invRegistration";
		}

		model.addAttribute("newInvestorOut", newInvestorOut);

		return "SavedInvestor";
	}

	@RequestMapping("/invValidate")
	public String invValidate(@Valid @ModelAttribute("investorLoginDto") LoginDto investorLoginDto,
			BindingResult result, Model model, HttpServletRequest request, HttpSession session) {
		if (result.hasErrors()) {
			return "invLogin";
		}

		session.invalidate();
		HttpSession newSession = request.getSession();

		boolean status = this.investorService.validateInvestor(investorLoginDto);
		newSession.setAttribute("Investor", investorLoginDto);
		if (status == true) {
			return "invHomePage";
		} else {
			model.addAttribute("Message", "Invalid Credentials");
			return "invLogin";
		}
	}

	@RequestMapping("/BOUserLogin")
	public String backOfficeUserLogin(Model model) {
		BackOfficeLoginDto backofficeuser = new BackOfficeLoginDto();
		model.addAttribute("backofficeuser", backofficeuser);
		return "BackOfficeUserLogin";
	}

	@PostMapping("/bovalidate")
	public String boLoginValidate(@Valid @ModelAttribute("backofficeuser") BackOfficeLoginDto user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "BackOfficeUserLogin";
		} else if (BackOfficeService.validateUser(user)) {
			return "BackOfficeUserHomePage";
		} else {
			model.addAttribute("Message", "Invalid Credentials");
			return "BackOfficeUserLogin";
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

	@RequestMapping("/InvestorLogin")
	public String userLogin(@ModelAttribute("investorLoginDto") LoginDto investorLoginDto) {
		return "invLogin";
	}

	@RequestMapping("/SuperUserLogin")
	public String superUserLogin(Model model) {
		AdminLoginDto superuser = new AdminLoginDto();
		model.addAttribute("superuser", superuser);
		return "SuperUserLogin";
	}

}
