package com.wf.training.bootapprestfulcrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapprestfulcrud.entity.BackOfficeUser;
import com.wf.training.bootapprestfulcrud.entity.SuperUser;
import com.wf.training.bootapprestfulcrud.service.SuperUserService;


@Controller
public class SuperUserController {
	
	@Autowired
	private SuperUserService superUserService;
	
	@RequestMapping("/bocreate")
	public String boCreate(Model model) {
		BackOfficeUser backofficeuser=new BackOfficeUser();
		model.addAttribute("backofficeuser", backofficeuser);
		return "backOfficeUserCreation";
	}
	
	@PostMapping("/confirm")
	public String boCreateConfirm(@Valid @ModelAttribute("backofficeuser") BackOfficeUser user,BindingResult result) {
		if(result.hasErrors())
			return "backOfficeUserCreation";
		else {
			if(this.superUserService.addBackOfficeUser(user))	
		return "BackOfficeUserCreated";
			else
				return "error";
		}
	}
	
	}
