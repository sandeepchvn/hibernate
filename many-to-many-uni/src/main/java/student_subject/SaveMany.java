package student_subject;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMany {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = new Student();
		student.setId(2);
		student.setName("deep");
		student.setEmail("deep@gmail.com");

		Subject sb1=em.find(Subject.class, 101);
		
		Subject sub2 = new Subject();
		sub2.setId(103);
		sub2.setName("gdgd");
		sub2.setDays(78);

		Subject sub3 =em.find(Subject.class, 102);
		

		List<Subject> subjects = Arrays.asList(sb1, sub2,sub3);
		
		student.setSubjects(subjects);
		
		et.begin();
		em.persist(student);
		em.persist(sub2);
		et.commit();
		System.out.println("saved----------!");
	}
}
