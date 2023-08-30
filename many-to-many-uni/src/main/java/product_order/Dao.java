package product_order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Arrays;

public class Dao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	public void save() {
		Product product=new Product();
		product.setId(1);
		product.setName("fghj");
		
		Product product1=new Product();
		product1.setId(2);
		product1.setName("fghj");
		
		Order1 order=new Order1();
		order.setId(443);
		order.setName("rt");
		
		Order1 order2=new Order1();
		order2.setId(44);
		order2.setName("rt");
		
		List<Order1> orders=java.util.Arrays.asList(order,order2);
		
		product.setOrders(orders);
		product1.setOrders(orders);
		
		
//		List<Product> products=java.util.Arrays.asList(product,product1);
//		order.se
		et.begin();
		em.persist(product);
		em.persist(product1);
		em.persist(order);
		em.persist(order2);
		et.commit();
		System.out.println("saved-------!");
	}
	public void delete() {
		Product product=em.find(Product.class, 1);
		if(product != null) {
			et.begin();
			em.remove(product);
			et.commit();
		}
	}
	public void update() {
		Product product=em.find(Product.class, 1);
		if(product != null) {
			product.setName("hgd");
			et.begin();
			em.merge(product);
			et.commit();
		}
	}
	public void find() {
		Product product=em.find(Product.class, 1);
		if(product != null) {
			System.out.println(product.getId());
			System.out.println(product.getName());
		}
	}
}
