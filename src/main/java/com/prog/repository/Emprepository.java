package com.prog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prog.entity.Employee;
@Repository

public interface Emprepository extends JpaRepository<Employee, Integer> {
	

}
