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

public class JunitUserDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in);

	public Userr saveUser(Userr u) {
		if (u != null) {
			et.begin();
			em.persist(u);
			et.commit();
			return em.find(Userr.class, u.getId());
		}
		return null;
	}

	public Userr findUser(int id) {
		Userr userr = em.find(Userr.class, id);
		if (userr != null) {
			return userr;
		}
		return null;
	}

	public boolean deleteUser(int id) {
		Userr userr = em.find(Userr.class, id);
		if (userr != null) {
			et.begin();
			em.remove(userr);
			et.commit();
			System.out.println("deleted--------!");
			return  true;
		}
		return false;
	}

	public Userr updateUser(int id, String email) {
		Userr userr = em.find(Userr.class, id);
		if (userr != null) {
			userr.setEmail(email);
			et.begin();
			em.merge(userr);
			et.commit();
		}
		return findUser(id);
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
