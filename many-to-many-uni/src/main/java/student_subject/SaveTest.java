package student_subject;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Student student = new Student();
		student.setId(1);
		student.setName("sandeep");
		student.setEmail("Sandeep@gmail.com");

		Subject subject1 = new Subject();
		subject1.setId(101);
		subject1.setName("java");
		subject1.setDays(78);

		Subject subject2 = new Subject();
		subject2.setId(102);
		subject2.setName("SQL");
		subject2.setDays(48);

		List<Subject> subjects = Arrays.asList(subject1, subject2);
		
		student.setSubjects(subjects);
		
		et.begin();
		em.persist(student);
		em.persist(subject1);
		em.persist(subject2);
		et.commit();
		System.out.println("saved----------!");
	}
}
