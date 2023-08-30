package com.tys.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InsertStudent {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		Query q=entityManager.createQuery("select s.name from Student s where id=?");
		q.setParameter(1, 1);
		q.getFirstResult();
		
		
		Student student=new Student();
//		student.setId(1);
//		student.setName("sandeep");
//		student.setEmail("sandeep@gmail.com");
//		entityTransaction.begin();
//		entityManager.persist(student);
//		entityTransaction.commit();
//		System.out.println("student saved into the table");
		Student s=entityManager.find(Student.class, 1);
		
		
		
		
		
		
		
	}
}
