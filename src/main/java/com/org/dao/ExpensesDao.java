package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.Expenses;
import com.org.dto.Month;
import com.org.dto.User;

public class ExpensesDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("routin");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void deleteExpensesById(int id) {

		Expenses expenses = em.find(Expenses.class, id);
//		
//		Month month = expenses.getMonth();
//		
//		User user = month.getUser();
//		   
//		int id2 = month.getId();
//		
//		 List<Month> months = user.getMonths();
//			 for(Month m:months) {
//				    if(m.getId()==id2) {
//				    	List<Expenses> expenses2 = m.getExpenses();
//				     for(Expenses e:expenses2) {
//				    	 if(e.getId()==id) {
//				    		 em.remove(e);
//				    		 break;
//				    	 }
//				     }
//				    }
//				 
//			 }
			 et.begin();
//			 em.merge(user);
//			 em.merge(month);
			 em.remove(expenses);
			 et.commit();
		 
		}
}
