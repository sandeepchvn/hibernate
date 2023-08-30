package car_engine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveCarEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car=new Car();
		car.setId(1);
		car.setName("honda");
		car.setCost(36673.3);
		
		Engine engine=new Engine();
		engine.setId(101);
		engine.setType("petrol");
		engine.setCc(1400);
		
		car.setEngine(engine);
		
		engine.setCar(car);
		
		et.begin();
		em.persist(car);
		em.persist(engine);
		et.commit();
		System.out.println("saved--------------!");
	}
	
}
