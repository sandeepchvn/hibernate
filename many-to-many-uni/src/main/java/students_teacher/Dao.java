package students_teacher;

import java.util.ArrayList;
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
		Students students=new Students();
		students.setId(2);
		students.setName("fgh");
		
		Students students2=new Students();
		students2.setId(1);
		students2.setName("fgh");
		
		Teacher teacher=new  Teacher();
		teacher.setId(45);
		teacher.setName("dfgh");
		
		List<Teacher> teachers=Arrays.asList(teacher);
		students.setTeacher(teachers);
		et.begin();
		em.persist(students2);
		em.persist(students);
		em.persist(teacher);
		et.commit();
	}
	public void delete() {
		Students students=em.find(Students.class, 1);
		if(students != null) 
		{
			et.begin();
			em.remove(students);
			et.commit();
			System.out.println("deleted------!");
		}
	}
	public void upadate() {
		Students students=em.find(Students.class, 1);
		if(students != null) 
		{
			students.setName("fhjgfhg");
			et.begin();
			em.merge(students);
			et.commit();
			System.out.println("deleted------!");
		}
	}
	public void find() {
		Students students=em.find(Students.class, 1);
		if(students != null) 
		{
			System.out.println(students.getId());
			System.out.println(students.getName());
			
			List<Teacher> teachers=students.getTeacher();
			for(Teacher teacher:teachers) {
				System.out.println(teacher.getId());
				System.out.println(teacher.getName());
			}
		}
	}
}
