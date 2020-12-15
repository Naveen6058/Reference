package com.wf.training.pms.service;

import java.util.List;

import com.wf.training.pms.dto.EmployeeInputDto;
import com.wf.training.pms.dto.EmployeeOutputDto;

public interface EmployeeService {

	public List<EmployeeOutputDto> fetchAllEmployees();
	public EmployeeOutputDto fetchSingleEmployee(Long id);
	public EmployeeOutputDto addEmployee(EmployeeInputDto employeeInputDto);
	public EmployeeOutputDto editEmployee(Long id, EmployeeInputDto employeeInputDto);
	public EmployeeOutputDto deleteEmployee(Long id);	
	
}
