package food_app.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import food_app.dto.Branch;
import food_app.dto.FoodApp;
import food_app.dto.FoodOrder;
import food_app.dto.FoodProduct;
import food_app.dto.Menu;
import food_app.dto.Userr;

public class UserrDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void saveUser() {
		Userr userr = new Userr();
		System.out.println("enter user id ");
		userr.setId(sc.nextInt());
		System.out.println("enter user Name ");
		userr.setName(sc.next());
		System.out.println("enter user Email ");
		userr.setEmail(sc.next());
		System.out.println("enter user Password ");
		userr.setPassword(sc.next());
		System.out.println("choose role of user \n1. BranchManager\n2. Admin\n3. Staff");
		int choice = (sc.nextInt());
		if (choice == 1) {
			userr.setRole("BranchManager");
		} else if (choice == 2) {
			userr.setRole("Admin");
		} else if (choice == 3) {
			userr.setRole("Staff");
		} else
			System.out.println("choice is wrong");
		if(userr != null) {
		et.begin();
		em.persist(userr);
		et.commit();
//		return true;
		}
		System.out.println("saved---!");

		
//		return false;
	}

	public void findUser() {
		System.out.println("enter the User id to get User");
		Userr userr = em.find(Userr.class, sc.nextInt());
		if (userr != null) {
			System.out.println("---------------------------");
			System.out.println("user id " + userr.getId());
			System.out.println("user Name " + userr.getName());
			System.out.println("user Email " + userr.getEmail());
			System.out.println("user Password " + userr.getPassword());
			System.out.println("user Role " + userr.getRole());
			System.out.println("--------------------------");
//			System.out.println("1. update email  /n2. delete User ");
			if (userr.getRole().equalsIgnoreCase("BranchManager")) {
				System.out.println("-------Menu-------");
				Menu menu = userr.getMenu();
				if (menu != null) {
					System.out.println("Menu id " + menu.getId());
					List<FoodProduct> foodProducts = menu.getFoodProducts();
					for (FoodProduct foodProduct : foodProducts) {
						System.out.println("----Food Product----");
						System.out.println("food product id " + foodProduct.getId());
						System.out.println("food product Name " + foodProduct.getName());
						System.out.println("food product Type " + foodProduct.getType());
						System.out.println("food product About " + foodProduct.getAbout());
						System.out.println("food product Availability " + foodProduct.getAvailability());
						System.out.println("food product Price " + foodProduct.getPrice());
					}
				}
			} else if (userr.getRole().equalsIgnoreCase("Staff")) {
				List<FoodOrder> foodOrders = userr.getFoodOrders();
				for (FoodOrder foodOrder : foodOrders) {
					System.out.println("Food Order id " + foodOrder.getId());
					System.out.println("Food Order status " + foodOrder.getStatus());
					System.out.println("Food Order price " + foodOrder.getTotalPrice());
					System.out.println("Food Order created time " + foodOrder.getOrderCreatedTime());
					System.out.println("Food Order updated time " + foodOrder.getOrderDeliveryTime());
					System.out.println("Food Order contcat number " + foodOrder.getContactNumber());

				}
			} else if (userr.getRole().equalsIgnoreCase("Admin")) {
				List<Branch> branchs = userr.getBranchs();
				for (Branch branch : branchs) {
					System.out.println("Branch id " + branch.getId());
					System.out.println("Branch Name " + branch.getId());
					System.out.println("Branch Address " + branch.getId());
					System.out.println("Branch Phone number " + branch.getId());
					System.out.println("Branch Email " + branch.getId());
				}
			}
		} else {
			System.out.println("id not exist do you want to create new User then press Y ");
			if (sc.next().equalsIgnoreCase("y"))
				saveUser();
		}

	}

	public void deleteUser() {
		System.out.println("enter the User id to delete");
		Userr userr = em.find(Userr.class, sc.nextInt());
		if (userr != null) {
			et.begin();
			em.remove(userr);
			et.commit();
			System.out.println("deleted--------!");
		}
	}

	public void updateUser() {
		System.out.println("enter the User id to update");
		Userr userr = em.find(Userr.class, sc.nextInt());
		if (userr != null) {
			System.out.println("enter the new Email");
			userr.setEmail(sc.next());
			et.begin();
			em.merge(userr);
			et.commit();
			System.out.println("updated--------!");
		}
	}

	public void setMenuToUserBranchManager() {
		System.out.println("enter Menu id to get Menu");
		Menu menu = em.find(Menu.class, sc.nextInt());
		if (menu != null) {
			System.out.println("enter the user id");
			Userr user = em.find(Userr.class, sc.nextInt());
			menu.setUserr(user);
			et.begin();
			em.merge(menu);
			et.commit();
			System.out.println("User has menu");
		}
	}

	public void setBranchToUserAdmin() {

		System.out.println("enter the Branch id to get branch");
		Branch branch = em.find(Branch.class, sc.nextInt());
		if (branch != null) {
			System.out.println("enter the user id");
			Userr userr = em.find(Userr.class, sc.nextInt());
			branch.setUserr(userr);
			et.begin();
			em.merge(branch);
			et.commit();
			System.out.println("user has branch");
		}
	}

	public void setFoodOrderToUserStaff() {
		System.out.println("enter the Food Order id ");
		FoodOrder foodOrder = em.find(FoodOrder.class, sc.nextInt());
		if (foodOrder != null) {
			System.out.println("enter the user id");
			Userr user = em.find(Userr.class, sc.nextInt());
			foodOrder.setUserr(user);
			et.begin();
			em.merge(foodOrder);
			et.commit();
			System.out.println("User has food order");
		}
	}

	public void printUserByRole(List<Userr> userrs) {
		for (Userr userr : userrs) {
			System.out.println("user id " + userr.getId());
			System.out.println("user Name " + userr.getName());
			System.out.println("user Email " + userr.getEmail());
			System.out.println("user Password " + userr.getPassword());
			System.out.println("user Role " + userr.getRole());
		}
	}

	public void findUserByRole() {
		System.out.println("choose the role of User \n1. BRANCHMANAGER\n2. STAFF\n3. ADMIN");
		Query query = em.createQuery("select u from Userr u where u.role=?1");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			query.setParameter(1, "BranchManger");

			break;
		}
		case 2: {
			query.setParameter(2, "Staff");
			break;
		}
		case 3: {
			query.setParameter(3, "Admin");
			break;
		}
		default: {
			System.out.println("choise is wrong");
		}
		}
		List<Userr> userrs = query.getResultList();
		printUserByRole(userrs);
	}
}
