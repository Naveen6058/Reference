package com.wf.training.pms.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.training.pms.dto.EmployeeInputDto;
import com.wf.training.pms.dto.EmployeeOutputDto;
import com.wf.training.pms.entity.Employee;
import com.wf.training.pms.repository.EmployeeRepository;
import com.wf.training.pms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	@Override
	public List<EmployeeOutputDto> fetchAllEmployees() {

		List<Employee> employees = this.EmployeeRepository.findAll();
		List<EmployeeOutputDto> employeeDtos = 
					employees.stream()
							 .map(this :: convertEntityToOutputDto)
							 .collect(Collectors.toList());
		return employeeDtos;
	}

	@Override
	public EmployeeOutputDto fetchSingleEmployee(Long id) {
		
		Employee employee = this.EmployeeRepository.findById(id).orElse(null);
		EmployeeOutputDto employeeOutputDto =  this.convertEntityToOutputDto(employee);
		return employeeOutputDto;
	}

	@Override
	public EmployeeOutputDto addEmployee(EmployeeInputDto employeeInputDto) {
	
		Employee employee = this.covertInputDtoToEntity(employeeInputDto);
		Employee newEmployee = this.EmployeeRepository.save(employee);
		EmployeeOutputDto employeeOutputDto = this.convertEntityToOutputDto(newEmployee);
		return employeeOutputDto;
	}

	@Override
	public EmployeeOutputDto editEmployee(Long id, EmployeeInputDto employeeInputDto) {
		
		Employee employee = this.covertInputDtoToEntity(employeeInputDto);
		employee.setId(id);
		Employee updatedEmployee = this.EmployeeRepository.save(employee);
		EmployeeOutputDto employeeOutputDto = this.convertEntityToOutputDto(updatedEmployee);
		return employeeOutputDto;
	}

	@Override
	public EmployeeOutputDto deleteEmployee(Long id) {
	
		EmployeeOutputDto employeeOutputDto = this.fetchSingleEmployee(id);
		this.EmployeeRepository.deleteById(id);
		return employeeOutputDto;
	}
	
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

}
