package com.ty;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NamedParameter {
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
//		Query query = em.createQuery("Select s from Student s where s.id=:my_id and s.name=:my_name");
//		query.setParameter("my_id", 1);
//		query.setParameter("my_name", "sandeep");
//		Student s = (Student) query.getSingleResult();
//
//		System.out.println(s.getPhone());

		Query query = em.createQuery("update  Student s set s.name=?1 where s.id=?2 ");
		query.setParameter(1, "sandu");
		query.setParameter(2, 1);
		EntityTransaction tr =  em.getTransaction();
		tr.begin();
		query.executeUpdate();
		tr.commit();
	}
}
