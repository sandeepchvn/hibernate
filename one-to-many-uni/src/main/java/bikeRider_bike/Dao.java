package bikeRider_bike;

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
		BikeRider bikeRider = new BikeRider();
		bikeRider.setId(1);
		bikeRider.setName("abc");

		Bike bike = new Bike();
		bike.setId(101);
		bike.setName("honda");

		Bike bike1 = new Bike();
		bike1.setId(102);
		bike1.setName("honda");

		List<Bike> bikes = Arrays.asList(bike, bike1);
		bikeRider.setBike(bikes);

		et.begin();
		em.persist(bike1);
		em.persist(bike);
		em.persist(bikeRider);
		et.commit();
		System.out.println("saved-------------!");

	}

	public void delete() {
		BikeRider bikeRider = em.find(BikeRider.class, 1);
		if (bikeRider != null) {
			et.begin();
			em.remove(bikeRider);
			et.commit();
			System.out.println("deleted-------------!");
		}
	}

	public void update() {
		BikeRider bikeRider = em.find(BikeRider.class, 1);
		if (bikeRider != null) {
			bikeRider.setName("sdfghj");
			et.begin();
			em.merge(bikeRider);
			et.commit();
			System.out.println("updated-------------!");
		}
	}

	public void find() {
		BikeRider bikeRider = em.find(BikeRider.class, 1);
		if (bikeRider != null) {
			System.out.println(bikeRider.getId());
			System.out.println(bikeRider.getName());
			List<Bike> bikes = bikeRider.getBike();
			for (Bike bike : bikes) {
				System.out.println(bike.getId());
				System.out.println(bike.getName());
			}
		}
	}
}
