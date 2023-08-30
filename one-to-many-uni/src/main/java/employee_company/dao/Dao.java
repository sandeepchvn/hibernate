package employee_company.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import employee_company.dto.Company;
import employee_company.dto.Employee;

public class Dao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void save() {
		Company company = new Company();
		System.out.println("enter id,name,gst number,registretion of company");
		company.setId(sc.nextInt());
		company.setName(sc.next());
		company.setGst_num(sc.next());
		company.setRegistretion(sc.next());

		Employee emp = new Employee();
		System.out.println("enter id, name,phone,email of employee");
		emp.setId(sc.nextInt());
		emp.setName(sc.next());
		emp.setPhone(sc.nextLong());
		emp.setEmail(sc.next());

		System.out.println("enter id, name,phone,email of employee");
		Employee emp2 = new Employee();
		emp2.setId(sc.nextInt());
		emp2.setName(sc.next());
		emp2.setPhone(sc.nextLong());
		emp2.setEmail(sc.next());

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(emp);
		employees.add(emp2);

		company.setEmployees(employees);
		et.begin();
		em.persist(emp);
		em.persist(emp2);
		em.persist(company);
		et.commit();
		System.out.println("saved-----!");
	}

	public void delete() {
		System.out.println("enter the iD to delete ");
		Company comp = em.find(Company.class, sc.nextInt());
		if (comp != null) {
			et.begin();
			em.remove(comp);
			et.commit();
			System.out.println("done---!");
		}
	}

	public void find() {
		System.out.println("enter the iD to find ");
		Company comp = em.find(Company.class, sc.nextInt());
		if (comp != null) {
			System.out.println(comp.getId());
			System.out.println(comp.getName());
			System.out.println(comp.getGst_num());
			System.out.println(comp.getRegistretion());
			System.out.println("----------------");
			List<Employee> emps = comp.getEmployees();
			for (Employee emp : emps) {
				System.out.println(emp.getId());
				System.out.println(emp.getName());
				System.out.println(emp.getPhone());
				System.out.println(emp.getEmail());
			}
		}
	}
	public void update() {
		System.out.println("enter the iD to update phone of Employee ");
		Employee emp = em.find(Employee.class, sc.nextInt());
		if (emp != null) {
			System.out.println("give the new phone number");
			emp.setPhone(sc.nextLong());
			et.begin();
			em.merge(emp);
			et.commit();
			System.out.println("done---!");
		}
	}
}
