package bank_customer;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Dao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save() {
		Bank bank = new Bank();
		bank.setId(2);
		bank.setName("hg");

		Customer customer = new Customer();
		customer.setId(63);
		customer.setName("yttd");

		Customer customer1 = new Customer();
		customer1.setId(53);
		customer1.setName("yttd");

		List<Customer> customers = Arrays.asList(customer, customer1);

		bank.setCustomer(customers);

		et.begin();
		em.persist(bank);
		em.persist(customer);
		em.persist(customer1);
		et.commit();
	}
	public void delete() {
		Bank bank=em.find(Bank.class, 2);
		if(bank != null) {
			et.begin();
			em.remove(bank);
			et.commit();
		}
	}
	public void update() {
		Bank bank=em.find(Bank.class, 2);
		if(bank != null) {
			bank.setName("dhgd");
			et.begin();
			em.merge(bank);
			et.commit();
		}
	}public void find() {
		Bank bank=em.find(Bank.class, 2);
		if(bank != null) {
			System.out.println(bank.getId());
			System.out.println(bank.getName());
		}
	}
}
