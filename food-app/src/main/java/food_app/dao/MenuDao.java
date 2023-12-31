package food_app.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import food_app.dto.FoodProduct;
import food_app.dto.Menu;

public class MenuDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void saveMenu() {
		Menu menu = new Menu();
		System.out.println("enter menu id");
		menu.setId(sc.nextInt());
		et.begin();
		em.persist(menu);
		et.commit();
		System.out.println("saved----------!");
	}

	public void findMenu() {
		System.out.println("enter Menu id to get Menu");
		Menu menu = em.find(Menu.class, sc.nextInt());
		if (menu != null) {
			System.out.println("Menu id " + menu.getId());
			List<FoodProduct> foodProducts = menu.getFoodProducts();
			for (FoodProduct foodProduct : foodProducts) {
				System.out.println("food product id " + foodProduct.getId());
				System.out.println("food product Name " + foodProduct.getName());
				System.out.println("food product Type " + foodProduct.getType());
				System.out.println("food product About " + foodProduct.getAbout());
				System.out.println("food product Availability " + foodProduct.getAvailability());
				System.out.println("food product Price " + foodProduct.getPrice());
			}
		} else
			System.out.println("menu id is not present");
	}

	public void deleteMenu() {
		System.out.println("enter Menu id to delete Menu");
		Menu menu = em.find(Menu.class, sc.nextInt());
		if (menu != null) {
			et.begin();
			em.remove(menu);
			et.commit();
			System.out.println("deleted----------!");
		}
	}
}
