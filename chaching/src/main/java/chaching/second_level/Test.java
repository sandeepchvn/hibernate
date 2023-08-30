package chaching.second_level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import chaching.first_level.Engine;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em1 = emf.createEntityManager();
//		 EntityTransaction et = em1.getTransaction();
//		Engine1 engine=new Engine1();
//		engine.setId(21);
//		engine.setType("perol");
//		engine.setCc(1500);
		// 1st EM
		Engine engine1 = em1.find(Engine.class, 21);
		System.out.println(engine1);

		Engine engine2 = em1.find(Engine.class, 21);
		System.out.println(engine2);
		Engine engine3 = em1.find(Engine.class, 21);
		System.out.println(engine3);

		Engine engine4 = em1.find(Engine.class, 21);
		System.out.println(engine4);

		EntityManager em2 = emf.createEntityManager();
		// 2nd EM
		Engine engine5 = em1.find(Engine.class, 21);
		System.out.println(engine5);
		Engine engine6 = em1.find(Engine.class, 21);
		System.out.println(engine6);

	}
}
