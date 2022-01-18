package com.javatpoint.hibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javatpoint.model.Employee;

public class HibernateUtilClass {

	public static Session sessionObjectreturn() {
		Configuration con = new Configuration();
		con.configure();
		con.addAnnotatedClass(Employee.class);
		SessionFactory sess = con.buildSessionFactory();
		Session se = sess.openSession();
		return se;

	}

}
