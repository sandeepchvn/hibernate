package customer_items;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save() {
		Customer customer = new Customer();
		customer.setId(5);
		customer.setName("deep");
		customer.setAddress("BT");

		Item item1 =em.find(Item.class, 104);
		Item item2 =em.find(Item.class, 102) ;
//		Item item1 = new Item();
//		item1.setId(103);
//		item1.setName("i phone");
//
//		Item item2 = new Item();
//		item2.setId(104);
//		item2.setName("hp lap");
		// giving customer to item
		item1.setCustomer(customer);
		item2.setCustomer(customer);

		// giving items to customer
		List<Item> items = Arrays.asList(item1, item2);
		customer.setItems(items);
		et.begin();
		em.persist(customer);
		em.persist(item1);
		em.persist(item2);
		et.commit();
		System.out.println("saved-------------!");
	}

	public void deleteCustomer() {
		Customer customer = em.find(Customer.class, 1);
		List<Item> items = customer.getItems();
		Iterator it = items.iterator();

		while (it.hasNext()) {
//			it
		}
		if (customer != null) {
			et.begin();
			em.remove(customer);
			et.commit();
			System.out.println("deleted  Customer----------!");
		}
	}

	public void deleteItem() {
		Item item = em.find(Item.class, 103);
		if (item != null) {
			et.begin();
			em.remove(item);
			et.commit();
			System.out.println("deleted  Item-----------!");
		}
	}

	public void update() {
		Customer customer = em.find(Customer.class, 1);
		if (customer != null) {
			customer.setAddress("indicube");
			et.begin();
			em.merge(customer);
			et.commit();
			System.out.println("updated-----------!");
		}
	}

	public void find() {
		Customer customer = em.find(Customer.class, 1);
		if (customer != null) {
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			System.out.println(customer.getAddress());

			List<Item> items = customer.getItems();
			for (Item item : items) {
				System.out.println(item.getId());
				System.out.println(item.getName());
			}
		}
	}
	
}
