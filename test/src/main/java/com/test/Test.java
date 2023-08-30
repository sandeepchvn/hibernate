package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory e = Persistence.createEntityManagerFactory("vikas");
		EntityManager manager=e.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		//manager.find(Student.class)
	}
}