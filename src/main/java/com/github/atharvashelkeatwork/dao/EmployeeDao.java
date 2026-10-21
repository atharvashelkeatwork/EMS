package com.github.atharvashelkeatwork.dao;

import java.util.List;

import com.github.atharvashelkeatwork.entity.Employee;
import com.github.atharvashelkeatwork.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeDao {
	
	public void saveEmployee(Employee employee) {
		EntityManager em = HibernateUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(employee);
			et.commit();
		}catch(Exception e) {
			et.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public List<Employee> findAllUsers() {
		EntityManager em = HibernateUtil.getEntityManager();
	    return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
	}
	
	public void deleteUser(int id) {
		EntityManager em = HibernateUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.remove(em.find(Employee.class, id));
			et.commit();
		}catch(Exception e) {
			et.rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public Employee findUser(int id) {
		EntityManager em = HibernateUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		return em.find(Employee.class, id);
	}

	public void updateEmployee(Employee employee) {
	    EntityManager em = HibernateUtil.getEntityManager();
	    EntityTransaction et = em.getTransaction();
	    try {
	        et.begin();
	        em.merge(employee);
	        et.commit();
	    } catch(Exception e) {
	        if (et != null && et.isActive()) {
	            et.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }
	}


}
