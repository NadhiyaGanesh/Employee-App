package com.ty.employeeapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.employeeapp.dto.EmployeeDto;

@Repository
public class EmployeeDao {

	@Autowired
	private EntityManagerFactory factory;
	
	public EmployeeDto insertEmployee(EmployeeDto employeeDto) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(employeeDto);
			transaction.commit();
			return employeeDto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	}

	public List<EmployeeDto> getAllEmployee() {
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery("FROM EmployeeDto");
		return query.getResultList();
	}

	public EmployeeDto searchEmployee(int employeeId) {
		EntityManager manager=factory.createEntityManager();
		return manager.find(EmployeeDto.class, employeeId);
	}

	public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.merge(employeeDto);
			transaction.commit();
			return employeeDto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	}

	public EmployeeDto deleteEmployee(EmployeeDto employeeDto) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			EmployeeDto dto = manager.merge(employeeDto);
			manager.remove(dto);
			transaction.commit();
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	}
}
