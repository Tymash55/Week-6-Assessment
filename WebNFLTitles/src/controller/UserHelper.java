package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

public class UserHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleNFLTitles");
	
	public void insertUser(User s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<User> showAllUsers(){
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<User> allUsers = em.createQuery("Select s FROM User s").getResultList();
		return allUsers;
	}
}
