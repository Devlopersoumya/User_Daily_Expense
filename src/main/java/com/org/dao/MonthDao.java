package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Month;

public class MonthDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("routin");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void saveAndUpdateMonth(Month month) {
		et.begin();
		em.merge(month);
		et.commit();
	}
	
	public Month FetchMonthById(int id) {
		return em.find(Month.class, id);
	}
	
	public List<Month> fetchAllMonth(){
		Query query = em.createQuery("select s from Month s");
		List<Month> monthlist = query.getResultList();
		return monthlist;
	}
}
