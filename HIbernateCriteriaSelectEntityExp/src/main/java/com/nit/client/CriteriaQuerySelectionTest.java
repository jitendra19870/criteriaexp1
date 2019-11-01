package com.nit.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nit.model.Employee;
import com.nit.util.HibernateUtil;

public class CriteriaQuerySelectionTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			Transaction tx=session.beginTransaction();
			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery =builder.createQuery(Employee.class);
			Root<Employee> root=criteriaQuery.from(Employee.class);
			criteriaQuery.select(root);
		Query<Employee> query=session.createQuery(criteriaQuery);
		List<Employee> empList=query.list();
		empList.forEach(System.out::println);
		
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
