package com.prog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Employee;
import com.prog.service.EmpServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;

@Tag(name="Employee Controller", description ="Employee Controller")
@Controller
public class Empcontroller {
	@Autowired
	private EmpServiceImpl service;

@Operation(summary = "Display Employees", description = "Display Employees")
@GetMapping("/")
public String home(Model m)
{
	System.out.println("get all employees");
	List<Employee> emp=service.getAllEmp();	
	m.addAttribute("emp",emp);
return "index";	
}

@GetMapping("/addemp")
public String addEmpForm()
{
	return "add-emp";
}
@Operation(summary = "Register Employees", description = "Register Employees")
@PostMapping("/register")
public String empRegister(@ModelAttribute Employee e,HttpSession session) {
	System.out.println(e);
	service.addEmp(e);
	session.setAttribute("msg","Employee Added Sucessfully... ");
	return "redirect:/";
}
@GetMapping("/edit/{id}")
public String edit(@PathVariable int id,Model m) {
	System.out.println(id);
	Employee e=service.getEmpById(id);
	m.addAttribute("emp", e);
	return "update";
}
@Operation(summary = "Update Employees", description = "Update Employees")
@PostMapping("edit/update")
public String updateEmp(@ModelAttribute Employee e,HttpSession session) {
	System.out.println(e);
	service.updateEmp(e);
	session.setAttribute("msg", "Employee data updated sucessfully");
	return "redirect:/";
}

@Operation(summary = "Delete Employee", description = "Delete Employee")
@GetMapping("/delete/{id}")
public String deleteEmp(@PathVariable int id,HttpSession session) {
	System.out.println(id);
	service.deleteEmp(id);
	session.setAttribute("msg", "Employee data Deleted sucessfully");
	return "redirect:/";
}
}