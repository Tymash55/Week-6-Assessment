package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

public class ListDetailsHelper {
	
	public static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleNFLTitles");
	
	public void insertNewListDetails(ListDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListDetails> getLists()	{
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}

}
