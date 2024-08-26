package com.prog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prog.entity.Employee;
import com.prog.repository.Emprepository;


@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private Emprepository repo;
	
	@Override
	public List<Employee> getAllEmp() {
		return repo.findAll();

	}

	@Override
	public void addEmp(Employee employee) {
		repo.save(employee);
		
	}
	
	@Override
	public void updateEmp(Employee employee) {
		repo.save(employee);
		
	}

	@Override
	public Employee getEmpById(int id) {
		Optional<Employee> e=repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;

	}

	@Override
	public void deleteEmp(int id) {
		 this.repo.deleteById(id);
		
	}
	
	 

}
