package com.ty.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.employeeapp.beans.Employee;
import com.ty.employeeapp.dto.EmployeeDto;
import com.ty.employeeapp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private  EmployeeService employeeService;
	
	@GetMapping("/index")
	public ModelAndView getHomePage(ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping("/add-employee")
	public ModelAndView addEmployee(ModelAndView modelAndView) {
		modelAndView.setViewName("add-employee-form");
		return modelAndView;
	}
	
	@PostMapping("/employee")
	public String insertEmployee(Employee employee,Model model) {
		EmployeeDto insertedEmployee=employeeService.insertEmployee(employee);
		if(insertedEmployee != null) {
			model.addAttribute("msg", "Employee Added Successfully");
			return "display-employee";
		} else {
			return "redirect:/add-employee";
		}
	}
	
	@GetMapping("/display-all")
	public ModelAndView viewAllEmployee(ModelAndView modelAndView,Model model) {
		
		List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
		model.addAttribute("emp", allEmployee);
		modelAndView.setViewName("display-all-employee");
		return modelAndView;
	}
	
	@GetMapping("/search-employee-page")
	public ModelAndView getSearchEmployeePage(ModelAndView modelAndView) {
		modelAndView.setViewName("search-employee-form");
		return modelAndView;
	}
	
	@GetMapping("/edit")
	public ModelAndView getEditEmployeeForm(ModelAndView modelAndView,Model model,@RequestParam("employeeId") int employeeId) {
		EmployeeDto searchedEmployee = employeeService.searchEmployee(employeeId);
		if(searchedEmployee == null) {
			model.addAttribute("msg", "invalid id please enter correct id"+employeeId);
			modelAndView.setViewName("display-employee");
		} else {
			model.addAttribute("employee", searchedEmployee);
			modelAndView.setViewName("edit-employee-page");
		}
		return modelAndView;
	}
	
	@PostMapping("/update-employee")
	public String updateEmployee(Employee employee,ModelAndView modelAndView,@RequestParam("employeeId") int id) {
		EmployeeDto employeeDto = employeeService.updateEmployee(id,employee);
		return "redirect:/display-all";
	}
	
	@GetMapping("/delete-employee-page")
	public ModelAndView getDeletePageForm(ModelAndView modelAndView) {
		modelAndView.setViewName("delete-employee-form");
		return modelAndView;
	}
	
	@GetMapping("/delete-employee")
	public String deleteEmployee(@RequestParam("employeeId") int employeeId,Model model,ModelAndView modelAndView) {
		EmployeeDto employeeDto=employeeService.deleteEmployee(employeeId);
		if(employeeDto==null) {
			model.addAttribute("msg", "employee id is not found"+employeeId);
			return "display-all";
		} else {
			return "redirect:/display-all";
		}
	}
}
