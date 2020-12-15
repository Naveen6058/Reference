package com.wf.training.pms.controller;

import com.wf.training.pms.dto.EmployeeOutputDto;
import com.wf.training.pms.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class EmpViewController {

	@Autowired
	private EmployeeService empService;
	
	@RequestMapping("/list")
	public String employeeList(Model model) {
		List<EmployeeOutputDto> employees = this.empService.fetchAllEmployees();
		model.addAttribute("employees", employees);
		return "employee-list";
	}
}
