package com.javatpoint.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Employee;

@Service
public class EmployeeService {

	public Boolean addEmployee(Employee emp) {
		Configuration con = new Configuration();
		con.configure();
		SessionFactory sess = con.buildSessionFactory();
		Session se = sess.openSession();
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

	public Employee getEmployee(int id) {
		Configuration con = new Configuration();
		con.configure();
		SessionFactory sess = con.buildSessionFactory();
		Session se = sess.openSession();
		Employee emp = se.get(Employee.class, id);
		return emp;
	}

	public List<Employee> getALlEmployeesInDB() {
		Configuration con = new Configuration();
		con.configure();
		SessionFactory sess = con.buildSessionFactory();
		Session se = sess.openSession();
		Query query = se.createQuery("from Employee");
		List<Employee> empList = query.list();
		return empList;
	}

	public boolean updateEmployeeInDB(Employee emp) {
		Configuration con = new Configuration();
		con.configure();
		SessionFactory sess = con.buildSessionFactory();
		Session se = sess.openSession();
		se.update(emp);
		Transaction t = se.beginTransaction();
		try {
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteEmployeeInDB(Employee emp) {
		Configuration con = new Configuration();
		con.configure();
		SessionFactory sess = con.buildSessionFactory();
		Session se = sess.openSession();
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

}
