package com.ty;

import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PositionParameter {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et = em.getTransaction();

//		Student s = new Student();
//		s.setId(2);
//		s.setName("gagan");
//		s.setPhone(2234336);
//		
//		et.begin();
//		em.persist(s);
//		et.commit();

		Query q = em.createQuery("select s from Student s where s.id=?1");
		q.setParameter(1, 1);
		List<Student> s=q.getResultList();
		for (Student student : s) {
			System.out.println(student.getName());
		}
	}
}
