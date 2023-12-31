package food_app.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import food_app.dto.FoodProduct;
import food_app.dto.Menu;

public class FoodProductDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Scanner sc=new Scanner(System.in);
	public void saveFoodProduct() {
		FoodProduct foodProduct=new FoodProduct();
		System.out.println("enter the Food product id");
		foodProduct.setId(sc.nextInt());
		System.out.println("enter the Food product Name");
		foodProduct.setName(sc.next());
		System.out.println("enter the Food product Type");
		foodProduct.setType(sc.next());
		System.out.println("enter About the Food product");
		foodProduct.setAbout(sc.next());
		System.out.println("enter the Food product Availability");
		foodProduct.setAvailability(sc.next());
		System.out.println("enter the Food product price");
		foodProduct.setPrice(sc.nextDouble());
		et.begin();
		em.persist(foodProduct);
		et.commit();
		System.out.println("saved----------------!");
	}
	public void findFoodProduct() {
		System.out.println("enter the FoodProduct id to get FoodProduct ");
		FoodProduct foodProduct=em.find(FoodProduct.class, sc.nextInt());
		if (foodProduct != null) {
			System.out.println("food product id "+foodProduct.getId());
			System.out.println("food product Name "+foodProduct.getName());
			System.out.println("food product Type "+foodProduct.getType());
			System.out.println("food product About "+foodProduct.getAbout());
			System.out.println("food product Availability "+foodProduct.getAvailability());
			System.out.println("food product Price "+foodProduct.getPrice());
		}
	}
	public void deleteFoodProduct() {
		System.out.println("enter the Food Product Id to delete the FoodProduct");
		FoodProduct foodProduct=em.find(FoodProduct.class, sc.nextInt());
		if (foodProduct != null) {
			et.begin();
			em.remove(foodProduct);
			et.commit();
			System.out.println("deleted-------!");
		}
	}
	public void updateFoodProduct() {
		System.out.println("enter the Food Product Id to update the Availability");
		FoodProduct foodProduct=em.find(FoodProduct.class, sc.nextInt());
		if (foodProduct != null) {
			System.out.println("enter the availability of Food product");
			foodProduct.setAvailability(sc.next());
			et.begin();
			em.merge(foodProduct);
			et.commit();
			System.out.println("updated------------!");
		}
	}
	public void setFoodProductToMenu() {
		System.out.println("enter Menu id to get Menu");
		Menu menu=em.find(Menu.class, sc.nextInt());
		if(menu != null) {
			System.out.println("enter food product id ");
			FoodProduct foodProduct= em.find(FoodProduct.class, sc.nextInt());
			foodProduct.setMenu(menu);
			et.begin();
			em.merge(foodProduct);
			et.commit();
			System.out.println("Menu Has Food Product");
		}
	}
}
