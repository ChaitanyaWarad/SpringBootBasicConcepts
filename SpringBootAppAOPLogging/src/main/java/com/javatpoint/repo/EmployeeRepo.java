package com.javatpoint.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
