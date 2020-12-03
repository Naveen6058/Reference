package com.wf.training.bootapprestfulcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.training.bootapprestfulcrud.dto.EmployeeOutputDto;
import com.wf.training.bootapprestfulcrud.service.EmployeeService;

@Controller
public class EmployeeViewController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/list")
	public String employeeList(Model model) {
		List<EmployeeOutputDto> employees = this.service.fetchAllEmployees();
		model.addAttribute("employees", employees);
		return "employee-list";
	}
}
