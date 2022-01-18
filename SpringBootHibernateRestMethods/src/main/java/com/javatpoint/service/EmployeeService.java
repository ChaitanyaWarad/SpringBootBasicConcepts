package com.javatpoint.service;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.javatpoint.hibernateUtil.HibernateUtilClass;
import com.javatpoint.model.Employee;

@Service
public class EmployeeService {

	public List<Employee> getAllEmployees() {
		Session se = HibernateUtilClass.sessionObjectreturn();
		Query<Employee> query = se.createQuery("from Employee");
		List<Employee> emp1 = query.list();
		return emp1;
	}

	public Employee getEmployeeByid(int empid) {
		Session se = HibernateUtilClass.sessionObjectreturn();
		Employee emp = se.load(Employee.class, empid);
		System.out.println(emp);
		return emp;
	}

	public boolean insertEmloyeeInDb(Employee emp) {
		Session se = HibernateUtilClass.sessionObjectreturn();
		se.save(emp);
		Transaction t = se.beginTransaction();
		try {
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteEmployeeById(int empid) {
		Session se = HibernateUtilClass.sessionObjectreturn();
		Employee emp = se.load(Employee.class, empid);
		se.delete(emp);
		Transaction t = se.beginTransaction();
		try {
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmployee(Employee emp) {
		Session se = HibernateUtilClass.sessionObjectreturn();
		se.saveOrUpdate(emp);
		Transaction t = se.beginTransaction();
		try {
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
