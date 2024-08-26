package com.prog.service;

import java.util.List;

import com.prog.entity.Employee;


public interface EmpService {
	List<Employee> getAllEmp();
    void addEmp(Employee employee);
    void updateEmp(Employee employee);
    Employee getEmpById(int id);
    void deleteEmp(int id);
	

}
