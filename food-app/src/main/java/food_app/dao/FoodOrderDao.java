package food_app.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import food_app.dto.FoodOrder;
import food_app.dto.Menu;
import food_app.dto.Userr;

public class FoodOrderDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	Scanner sc=new Scanner(System.in);
	public void saveFoodOrder() {
		FoodOrder foodOrder=new FoodOrder();
		System.out.println("enter Food Order Id");
		foodOrder.setId(sc.nextInt());
		System.out.println("enter Food Order Status");
		foodOrder.setStatus(sc.next());
		System.out.println("enter Food Order Price");
		foodOrder.setTotalPrice(sc.nextDouble());
		System.out.println("enter Food Order Time");
		foodOrder.setOrderCreatedTime(sc.next());
		System.out.println("enter Food Order Delivery time");
		foodOrder.setOrderDeliveryTime(sc.next());
		System.out.println("enter Food Ordered customer name");
		foodOrder.setCustomerName(sc.next());
		System.out.println("enter Food Ordered customer number");
		foodOrder.setContactNumber(sc.nextLong());
		et.begin();
		em.persist(foodOrder);
		et.commit();
		System.out.println("saved--------------!");
	}
	public void findFoodOrder() {
		System.out.println("enter the Food Order id to get Food Order");
		FoodOrder foodOrder=em.find(FoodOrder.class, sc.nextInt());
		if(foodOrder != null) {
			System.out.println("Food Order id "+foodOrder.getId());
			System.out.println("Food Order status "+foodOrder.getStatus());
			System.out.println("Food Order price "+foodOrder.getTotalPrice());
			System.out.println("Food Order created time "+foodOrder.getOrderCreatedTime());
			System.out.println("Food Order updated time "+foodOrder.getOrderDeliveryTime());
			System.out.println("Food Order contcat number "+foodOrder.getContactNumber());
			
		}
	}
	public void deleteFoodOrder() {
		System.out.println("enter the Food order id to delete");
		FoodOrder foodOrder=em.find(FoodOrder.class, sc.nextInt());
		if(foodOrder != null) {
			et.begin();
			em.remove(foodOrder);
			et.commit();
			System.out.println("deleted------------!");
		}
	}
	public void updateFoodOrder() {
		System.out.println("enter the Food order id to update contcat of customer");
		FoodOrder foodOrder=em.find(FoodOrder.class,sc.nextInt());
		if(foodOrder != null) {
			System.out.println("enter the customer number");
			foodOrder.setContactNumber(sc.nextLong());
			et.begin();
			em.merge(foodOrder);
			et.commit();
			System.out.println("updated-----------!");
		}
	}
	
}
