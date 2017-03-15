package com.chaos.stanfield.model;



import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.chaos.stanfield.utils.JPAInitEMF;

public class Main {
	  
	  public static void main(String[] args) {

		  JPAInitEMF jpa=new JPAInitEMF();
//		  List<Object> list=(List<Object>)jpa.queryEntities("select u from User u where u.email LIKE 'bhagyesh@gmailc.om'");
//		  System.out.println(" Size :::"+list.size());
//		  
//		  for (Object object : list) {
//			User u=(User)object;
//			System.out.println(u.toString());
//		  }
		  
//		  User uuu=new UserEvent();
//		  System.out.println(uuu.userByEmail("bhagyeshs@gmailc.om"));
//		  
//		  User us=new UserEvent();
//		  us.setEmail("sid@13.com");
//		  us.setFirstname("bhAGYESH");
//		  us.setLastname("dsfsdf");
//		  jpa.InsertEntity(us);
//		  
//	    Department dept=new Department();
//	    dept.setName("HR");
//	    Date d=new Date();
//	    em.persist(dept);
//	    Employee todo = new Employee(113, "Bhagyesh", 12345, "CS");
//	    todo.setDepartment(dept);
//	    em.persist(todo);
//	    Employee todo1 = new Employee(114, "Bhagyesh", 12345, "CS");
//	    todo1.setDepartment(dept);
//		em.persist(todo1);
	  }
	} 