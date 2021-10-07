package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Collection;

/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
public class CollectionHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GearCollection");
	
	public void insertNewCollection(Collection c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Collection> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<Collection> allDetails = em.createQuery("SELECT c FROM Collection c").getResultList();
		return allDetails;
	}
	
	public void deleteCollection(Collection toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Collection> typedQuery = em.createQuery("select collect from Collection collect where collect.id = :selectedId", Collection.class);
		
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Collection result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Collection searchForCollectionById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Collection found = em.find(Collection.class, tempId);
		em.close();
		return found;
	}
	
	public void updateCollection(Collection toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}


	public CollectionHelper() {
		// TODO Auto-generated constructor stub
	}

}
