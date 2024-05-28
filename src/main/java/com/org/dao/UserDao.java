package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.Month;
import com.org.dto.User;

public class UserDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("routin");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void savaAndUpdateUser(User user) {
	
		et.begin();
		em.merge(user);
		et.commit();
	}
	
	public User fetchUserById(int id) {
		return em.find(User.class, id);
	}
	public User fetchUserByEmailAndPwd(String email,String pwd) {
		Query query = em.createQuery("select s from User s where s.email=?1 and password=?2");
		query.setParameter(1, email);
		query.setParameter(2, pwd);
		List<User> list = query.getResultList();
		if(list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	}
	public List<Month> fetchMonthById(int id){
		User user = em.find(User.class,id);
		
		List<Month> months = user.getMonths();
		return months;
	}
}
