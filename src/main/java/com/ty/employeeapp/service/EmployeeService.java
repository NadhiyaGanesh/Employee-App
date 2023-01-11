package com.ty.employeeapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.employeeapp.beans.Employee;
import com.ty.employeeapp.dao.EmployeeDao;
import com.ty.employeeapp.dto.EmployeeDto;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeDto insertEmployee(Employee employee) {
		
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setEmailId(employee.getEmailId());
		LocalDate dateOfBirth = LocalDate.parse(employee.getDateOfBirth());
		employeeDto.setDateOfBirth(dateOfBirth);
		employeeDto.setSalary(employee.getSalary());
		employeeDto.setAge(employee.getAge());
		employeeDto.setEmployeeStatus(employee.getEmployeeStatus());
		
		return employeeDao.insertEmployee(employeeDto);
	}

	public List<EmployeeDto> getAllEmployee() {
		
		return employeeDao.getAllEmployee();
	}

	public EmployeeDto searchEmployee(int employeeId) {
		
		return employeeDao.searchEmployee(employeeId);
	}

	public EmployeeDto updateEmployee(int id, Employee employee) {
		
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setEmployeeName(employee.getEmployeeName());
		employeeDto.setEmailId(employee.getEmailId());
		LocalDate dateOfBirth = LocalDate.parse(employee.getDateOfBirth());
		employeeDto.setDateOfBirth(dateOfBirth);
		employeeDto.setSalary(employee.getSalary());
		employeeDto.setAge(employee.getAge());
		employeeDto.setEmployeeStatus(employee.getEmployeeStatus());
		
		return employeeDao.updateEmployee(employeeDto);
	}

	public EmployeeDto deleteEmployee(int employeeId) {
		EmployeeDto employeeDto=employeeDao.searchEmployee(employeeId);
		return employeeDao.deleteEmployee(employeeDto);
	}

}
