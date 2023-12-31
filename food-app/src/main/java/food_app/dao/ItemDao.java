package food_app.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import food_app.dto.FoodOrder;
import food_app.dto.Item;

public class ItemDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void saveItem() {
		Item item = new Item();
		System.out.println("enter item id");
		item.setId(sc.nextInt());
		System.out.println("enter product id");
		item.setProductId(sc.nextInt());
		System.out.println("enter item name");
		item.setName(sc.next());
		System.out.println("enter item type");
		item.setType(sc.next());
		System.out.println("enter item quantity");
		item.setQuantity(sc.next());
		System.out.println("enter item price");
		item.setPrice(sc.nextDouble());
		et.begin();
		em.persist(item);
		et.commit();
		System.out.println("saved-----------!");
	}

	public void findItem() {
		System.out.println("enter the item id to find");
		Item item = em.find(Item.class, sc.nextInt());
		if (item != null) {
			System.out.println("item id " + item.getId());
			System.out.println("product id " + item.getProductId());
			System.out.println("item name " + item.getName());
			System.out.println("item type " + item.getType());
			System.out.println("item quantity " + item.getQuantity());
			System.out.println("item price " + item.getPrice());
		}
	}

	public void deleteItem() {
		System.out.println("enter the item id to delete");
		Item item = em.find(Item.class, sc.nextInt());
		if (item != null) {
			et.begin();
			em.remove(item);
			et.commit();
			System.out.println("delted----------!");
		}
	}

	public void updateItem() {
		System.out.println("enter the item id to update");
		Item item = em.find(Item.class, sc.nextInt());
		if (item != null) {
			System.out.println("enter the updated price of item");
			item.setPrice(sc.nextDouble());
			et.begin();
			em.merge(item);
			et.commit();
			System.out.println("updated-----------------!");
		}
	}

	public void SetFoodOrderToItem() {
		System.out.println("enter the Food Order id");
		FoodOrder foodOrder = em.find(FoodOrder.class, sc.nextInt());
		System.out.println("enter the Item id");
		Item item = em.find(Item.class, sc.nextInt());
		if (item != null && foodOrder != null) {
			item.setFoodOrder(foodOrder);
			et.begin();
			em.merge(item);
			et.commit();
			System.out.print("Item has Food order");
		}
	}
}
