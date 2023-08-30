package car_engine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindCarEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();

		Car car = em.find(Car.class, 1);
		System.out.println("car id " + car.getId());
		System.out.println("car name " + car.getName());
		System.out.println("car cost " + car.getCost());

		Engine engine = car.getEngine();
		
		System.out.println("engine id "+engine.getId());
		System.out.println("engine Type "+engine.getType());
		System.out.println("engine cc "+engine.getCc());
	}
}
