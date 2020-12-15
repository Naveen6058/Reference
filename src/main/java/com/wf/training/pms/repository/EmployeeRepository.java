package com.wf.training.pms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.wf.training.pms.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
 
}
