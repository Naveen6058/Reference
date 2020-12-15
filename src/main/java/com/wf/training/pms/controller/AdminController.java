package com.wf.training.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import com.wf.training.pms.dto.BackofficeInputDto;
import com.wf.training.pms.service.AdminUserService;

@Controller
public class AdminController {

	@Autowired
	private AdminUserService adminUserService;

	@RequestMapping("/bocreate")
	public String boCreate(Model model) {
		
		BackofficeInputDto backofficeuser = new BackofficeInputDto();
		model.addAttribute("backofficeuser", backofficeuser);
		return "backOfficeUserCreation";
	}

	@PostMapping("/confirm")
	public String boCreateConfirm(@Valid @ModelAttribute("backofficeuser") BackofficeInputDto user,BindingResult result) {
		
		
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "backOfficeUserCreation";
		} else {
			if (this.adminUserService.addBackOfficeUser(user))
				return "BackOfficeUserCreated";
			else
				return "error";
		}
	}

}
