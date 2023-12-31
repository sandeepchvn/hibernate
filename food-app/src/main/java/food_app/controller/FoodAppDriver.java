package food_app.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import food_app.dao.BranchDao;
import food_app.dao.FoodOrderDao;
import food_app.dao.FoodProductDao;
import food_app.dao.ItemDao;
import food_app.dao.MenuDao;
import food_app.dao.UserrDao;

public class FoodAppDriver {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("welcom to food app");
		System.out.println("1. User\n2. Food Product\n3. Food Order\n4. Item\n5. Menun\n6. Branch ");
		
		while (true) {
			switch (sc.nextInt()) {
			case 1:{
				UserrDao userrDao = new UserrDao();
				System.out.println("enter your Id");
//				userrDao.saveUser();
//				userrDao.deleteUser();
//				userrDao.deleteUser();
				userrDao.findUser();
//				userrDao.findUserByRole();
//				userrDao.setBranchToUserAdmin();
//				userrDao.setFoodOrderToUserStaff();
				
//				userrDao.setMenuToUserBranchManager();
				break;
				}
			case 2:{
				FoodProductDao foodProductDao=new FoodProductDao();

//				foodProductDao.saveFoodProduct();
//				foodProductDao.deleteFoodProduct();
//				foodProductDao.updateFoodProduct();
//				foodProductDao.findFoodProduct();
				foodProductDao.setFoodProductToMenu();
				break;
			}
			case 3:
				FoodOrderDao foodOrderDao=new FoodOrderDao();

				foodOrderDao.saveFoodOrder();
//				foodOrderDao.deleteFoodOrder();
//				foodOrderDao.updateFoodOrder();
//				foodOrderDao.findFoodOrder();
				
				break;
			case 4:{
				ItemDao itemDao = new ItemDao();

				itemDao.saveItem();
//				itemDao.findItem();
//				itemDao.updateItem();
//				itemDao.deleteItem();
//				itemDao.SetFoodOrderToItem();
				break;
			}
			case 5:{
				MenuDao menuDao=new MenuDao();
				menuDao.saveMenu();
				
//				menuDao.findMenu();
//				menuDao.deleteMenu();
				break;
			}
			case 6:{
				BranchDao branchDao=new  BranchDao();
				branchDao.saveBrach();
//				branchDao.findBranch();
//				branchDao.updateBranch();
//				branchDao.deleteBranch();
				
				break;
			}
			default:System.out.println("choice is wrong");
				break;
			}
		}

	}
}
