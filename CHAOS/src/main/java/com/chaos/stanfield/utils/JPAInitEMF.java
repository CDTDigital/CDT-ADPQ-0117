package com.chaos.stanfield.utils;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAInitEMF {
	  private static final String PERSISTENCE_UNIT_NAME = "per";
	  private static EntityManagerFactory factory;
      private static EntityManager em;
	  static {
	        try {
	            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	            em = factory.createEntityManager();
	      	  
	        } catch (Throwable ex) {
	        	System.out.println("Entity Manager Factory > Static Method ::: "+ex.getMessage());
	        	throw new ExceptionInInitializerError(ex);
	        }
	  }
	  
	  public JPAInitEMF(){
		 
	  }
	  
	  public void InsertEntity(Object object){
		  if(!em.getTransaction().isActive()){
			 em.getTransaction().begin(); 
			 em.persist(object);
			  
		  }else{
			  em.persist(object);
		  }
		  em.getTransaction().commit();
	  }

	  
	  public List<Object> queryEntities(String query){
		  Query queryObj =  em.createQuery(query); 
	      List<Object> list=(List<Object>)queryObj.getResultList();
	      return list;
	  }
	  
	  public void updateEntity(Object object){
		  if(!em.getTransaction().isActive()){
			 em.getTransaction().begin();
			  em.merge(object);
		  }else{
			  em.merge(object);
		  }
		  em.getTransaction().commit();
	  }
	  
	  public void deleteEntity(Object object){
		  if(!em.getTransaction().isActive()){
				 em.getTransaction().begin();
		     	  em.remove(object);
		     		
			  }else{
			  }
	    em.getTransaction().commit();
	  }
	  
	  
	  public static EntityManager getEm() {
		return em;
	  } 

	  public static void setEm(EntityManager em) {
		JPAInitEMF.em = em;
	  }

}
