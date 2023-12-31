package food_app.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import food_app.dto.Branch;

public class BranchDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void saveBrach() {
		Branch branch = new Branch();
		System.out.println("enter Branch id");
		branch.setId(sc.nextInt());
		System.out.println("enter Branch NAme");
		branch.setName(sc.next());
		System.out.println("enter Branch Address");
		branch.setAddress(sc.next());
		System.out.println("enter Branch phone number");
		branch.setPhoneNumber(sc.nextLong());
		System.out.println("enter Branch email");
		branch.setEmail(sc.next());
		et.begin();
		em.persist(branch);
		et.commit();
		System.out.println("saved-------!");
	}

	public void findBranch() {
		System.out.println("enter the Branch id to get branch");
		Branch branch = em.find(Branch.class, sc.nextInt());
		if (branch != null) {
			System.out.println("Branch id " + branch.getId());
			System.out.println("Branch Name " + branch.getId());
			System.out.println("Branch Address " + branch.getId());
			System.out.println("Branch Phone number " + branch.getId());
			System.out.println("Branch Email " + branch.getId());
		}
	}

	public void deleteBranch() {
		System.out.println("enter the id to delete the branch");
		Branch branch = em.find(Branch.class, sc.nextInt());
		if (branch != null) {
			et.begin();
			em.remove(branch);
			et.commit();
			System.out.println("deleted------------!");
		}
	}

	public void updateBranch() {
		System.out.println("enter the id to update the branch");
		Branch branch = em.find(Branch.class, sc.nextInt());
		if (branch != null) {
			System.out.println("enter updated branch number");
			branch.setPhoneNumber(sc.nextLong());
			et.begin();
			em.merge(branch);
			et.commit();
			System.out.println("updated------------!");
		}

	}
}
