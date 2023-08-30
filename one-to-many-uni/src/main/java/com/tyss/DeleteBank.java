package com.tyss;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class DeleteBank {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Bank b = em.find(Bank.class, 1);
		List<Account> acounts = b.getAccounts();
		for (Account a : acounts) {
			if (a.getId() == 101) {
				//removing a from list, remove() is of List type not from hibernate 
				acounts.remove(a);
				b.setAccounts(acounts);
				em.merge(b);
				et.commit();
			}
		}
	}
}
