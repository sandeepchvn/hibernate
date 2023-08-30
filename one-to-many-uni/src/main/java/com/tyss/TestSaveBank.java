package com.tyss;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveBank {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Bank sbi = new Bank();
		sbi.setId(1);
		sbi.setIfse("SBI6353");
		sbi.setName("SBI");

		Account a1 = new Account();
		a1.setId(101);
		a1.setNumber(6337434l);
		a1.setBalance(9648999);

		Account a2 = new Account();
		a2.setId(102);
		a2.setNumber(7574l);
		a2.setBalance(6734464);
		// assigning accounts to the bank
		List<Account> accountss = new ArrayList<Account>();
		accountss.add(a1);
		accountss.add(a2);
		sbi.setAccounts(accountss);
		
		et.begin();
		em.persist(sbi);
		em.persist(a1);
		em.persist(a2);
		et.commit();
		System.out.println("saved !----");
	}
}
