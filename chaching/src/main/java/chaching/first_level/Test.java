package chaching.first_level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		// EntityTransaction et = em.getTransaction();
//		Engine engine=new Engine();
//		engine.setId(22);
//		engine.setType("perol");
//		engine.setCc(1500);
		Engine engine = em.find(Engine.class, 21);
		System.out.println("!-----------!");
		System.out.println(engine.getId());
		Engine engine2 = em.find(Engine.class, 21);

		System.out.println("!-----------!");
		//if you create one more object of EM then it will fetch data from DB
		EntityManager em2 = emf.createEntityManager();

		Engine engine1 = em2.find(Engine.class, 21);
		System.out.println(engine1.getId());

	}

}
