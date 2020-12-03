package com.wf.training.bootapprestfulcrud.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.wf.training.bootapprestfulcrud.dto.EmployeeInputDto;
import com.wf.training.bootapprestfulcrud.dto.EmployeeOutputDto;
import com.wf.training.bootapprestfulcrud.exception.EmployeeException;
import com.wf.training.bootapprestfulcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	// inject Service as dependency
	@Autowired
	private EmployeeService service;
	
	// fetch all records
	@GetMapping("/employees")
	public List<EmployeeOutputDto> fetchAll() {
		// call the service layer method
		List<EmployeeOutputDto> employees = this.service.fetchAllEmployees();
		return employees;
	}
	
	// fetch a record based on id
	@GetMapping("/employees/{id}")
	public EmployeeOutputDto fetchSingle(@PathVariable Long id) {
		EmployeeOutputDto employeeOutputDto =  this.service.fetchSingleEmployee(id);
		return employeeOutputDto;
	}
	
	// add a record
	@PostMapping("/employees")
	public EmployeeOutputDto save(@Valid @RequestBody EmployeeInputDto employeeInputDto,
								  BindingResult result) {
		if(result.hasErrors()) {
			throw new EmployeeException("Invalid data format!");
		}
		EmployeeOutputDto employeeOutputDto =  this.service.addEmployee(employeeInputDto);
		return employeeOutputDto;
	}
	
	// edit a record
	@PutMapping("/employees/{id}")
	public EmployeeOutputDto update(@PathVariable Long id, 
									@RequestBody EmployeeInputDto employeeInputDto) {
		EmployeeOutputDto employeeOutputDto = this.service.editEmployee(id, employeeInputDto);
		return employeeOutputDto;
	}
	
	// deleting a record
	@DeleteMapping("/employees/{id}")
	public EmployeeOutputDto delete(@PathVariable Long id) {
		EmployeeOutputDto employeeOutputDto = this.service.deleteEmployee(id);
		return employeeOutputDto;
	}
}













