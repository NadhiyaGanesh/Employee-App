package com.ty.employeeapp.beans;

public class Employee {
	
	private String employeeName;
	private String emailId;
	private String dateOfBirth;
	private int age;
	private double salary;
	private String employeeStatus;
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth
				+ ", age=" + age + ", salary=" + salary + ", employeeStatus=" + employeeStatus + "]";
	}
	
}
