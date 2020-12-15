package com.wf.training.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.validation.Valid;
import com.wf.training.pms.dto.EmployeeInputDto;
import com.wf.training.pms.dto.EmployeeOutputDto;
import com.wf.training.pms.exception.EmployeeException;
import com.wf.training.pms.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmpController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/employees/{id}")
	public EmployeeOutputDto fetchSingle(@PathVariable Long id) {
		EmployeeOutputDto employeeOutputDto = this.empService.fetchSingleEmployee(id);
		return employeeOutputDto;
	}

	@PostMapping("/employees")
	public EmployeeOutputDto save(@Valid @RequestBody EmployeeInputDto employeeInputDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new EmployeeException("Invalid data format!");
		}
		EmployeeOutputDto employeeOutputDto = this.empService.addEmployee(employeeInputDto);
		return employeeOutputDto;
	}

	@PutMapping("/employees/{id}")
	public EmployeeOutputDto update(@PathVariable Long id, @RequestBody EmployeeInputDto employeeInputDto) {
		EmployeeOutputDto employeeOutputDto = this.empService.editEmployee(id, employeeInputDto);
		return employeeOutputDto;
	}

	@GetMapping("/employees")
	public List<EmployeeOutputDto> fetchAll() {

		List<EmployeeOutputDto> employees = this.empService.fetchAllEmployees();
		return employees;
	}

	@DeleteMapping("/employees/{id}")
	public EmployeeOutputDto delete(@PathVariable Long id) {
		EmployeeOutputDto employeeOutputDto = this.empService.deleteEmployee(id);
		return employeeOutputDto;
	}
}
