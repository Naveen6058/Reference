package com.wf.training.bootapprestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bouser")
public class BoUserController {

	@RequestMapping("/validate")
	public String loginValidate() {
		// add business logic
		
		// respond back with a view page name
		return "index";
	}
}
