package com.wf.training.bootapprestfulcrud.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wf.training.bootapprestfulcrud.dto.EmployeeInputDto;
import com.wf.training.bootapprestfulcrud.dto.EmployeeOutputDto;
import com.wf.training.bootapprestfulcrud.entity.Employee;
import com.wf.training.bootapprestfulcrud.repository.EmployeeRepository;
import com.wf.training.bootapprestfulcrud.service.EmployeeService;

// @Component
@Service
public class EmployeeServiceImpl implements EmployeeService {

	// inject repository as dependency
	@Autowired
	private EmployeeRepository repository;
	
	// utility method
	private EmployeeOutputDto convertEntityToOutputDto(Employee employee) {
		EmployeeOutputDto employeeOutputDto = new EmployeeOutputDto();
		employeeOutputDto.setId(employee.getId());
		employeeOutputDto.setName(employee.getName());
		employeeOutputDto.setEmail(employee.getEmail());
		employeeOutputDto.setContact(employee.getContact());
		Double netSalary = employee.getBasicSalary() +
						   employee.getHra() + 
						   employee.getTa() + 
						   employee.getDa() -
						   employee.getPfDeduction();
		employeeOutputDto.setNetSalary(netSalary);
		return employeeOutputDto;
	}
	
	private Employee covertInputDtoToEntity(EmployeeInputDto employeeInputDto) {
		Employee employee = new Employee();
		employee.setName(employeeInputDto.getName());
		employee.setEmail(employeeInputDto.getEmail());
		employee.setContact(employeeInputDto.getContact());
		employee.setBasicSalary(employeeInputDto.getBasicSalary());
		Double basicSalary = employeeInputDto.getBasicSalary();
		Double hra = (basicSalary * 20)/100;
		Double ta = (basicSalary * 10)/100;
		Double da = (basicSalary * 10)/100;
		Double pfDeduction = (basicSalary * 15)/100;
		employee.setHra(hra);
		employee.setTa(ta);
		employee.setDa(da);
		employee.setPfDeduction(pfDeduction);
		return employee;
	}
	
	
	@Override
	public List<EmployeeOutputDto> fetchAllEmployees() {
		
		// use repository to fetch data from DB
		List<Employee> employees = this.repository.findAll();
		// convert entity into dto
		/*List<EmployeeOutputDto> employeeDtos = new ArrayList<EmployeeOutputDto>();
		for(Employee employee : employees) {
			EmployeeOutputDto employeeOutputDto = this.convertEntityToOutputDto(employee);
			employeeDtos.add(employeeOutputDto);
		}*/
		List<EmployeeOutputDto> employeeDtos = 
					employees.stream()
							 .map(this :: convertEntityToOutputDto)
							 .collect(Collectors.toList());
		return employeeDtos;
	}

	@Override
	public EmployeeOutputDto fetchSingleEmployee(Long id) {
		// fetch record from DB
		Employee employee = this.repository.findById(id).orElse(null);
		// convert entity into output dto
		EmployeeOutputDto employeeOutputDto =  this.convertEntityToOutputDto(employee);
		return employeeOutputDto;
	}

	@Override
	public EmployeeOutputDto addEmployee(EmployeeInputDto employeeInputDto) {
		// convert dto into entity
		Employee employee = this.covertInputDtoToEntity(employeeInputDto);
		// save entity in DB : returns the copy of newly added record back
		Employee newEmployee = this.repository.save(employee);
		// convert entity into output dto
		EmployeeOutputDto employeeOutputDto = this.convertEntityToOutputDto(newEmployee);
		return employeeOutputDto;
	}

	@Override
	public EmployeeOutputDto editEmployee(Long id, EmployeeInputDto employeeInputDto) {
		// convert dto into entity
		Employee employee = this.covertInputDtoToEntity(employeeInputDto);
		// assign the id to update
		employee.setId(id);
		// repository method to update
		// save : (upsert) : entity object : id(PK) empty/null/0 : insert else update
		Employee updatedEmployee = this.repository.save(employee);
		// convert entity into output dto
		EmployeeOutputDto employeeOutputDto = this.convertEntityToOutputDto(updatedEmployee);
		return employeeOutputDto;
	}

	@Override
	public EmployeeOutputDto deleteEmployee(Long id) {
		// get a copy of record
		EmployeeOutputDto employeeOutputDto = this.fetchSingleEmployee(id);
		// call repository method for deletion
		this.repository.deleteById(id);
		return employeeOutputDto;
	}

}
