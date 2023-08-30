package student_subject;

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

		Student student = new Student();
		student.setId(34);
		student.setEmail("fghj");
		student.setName("rrtjhk.");

		Student student1 = new Student();
		student1.setId(24);
		student1.setEmail("dhdj");
		student1.setName("dffjhk.");

		Subject subject = new Subject();
		subject.setId(456);
		subject.setDays(56);
		subject.setName("yujd");

		Subject subject1 = new Subject();
		subject1.setId(456);
		subject1.setDays(56);
		subject1.setName("yujd");

		List<Subject> subjects = Arrays.asList(subject, subject1);
		student.setSubjects(subjects);

		student1.setSubjects(subjects);
		System.out.println("saved---------!");
	}

	public void delete() {
		Student student = em.find(Student.class, 34);
		if (student != null) {
			et.begin();
			em.remove(student);
			et.commit();
		}
	}

	public void update() {
		Student student = em.find(Student.class, 34);
		if (student != null) {
			student.setName("dfghj");
			et.begin();
			em.merge(student);
			et.commit();
		}
	}

	public void find() {
		Student student = em.find(Student.class, 34);
		System.out.println(student.getId());
		System.out.println(student.getName());
		List<Subject> subjects = student.getSubjects();
		for(Subject subject:subjects) {
			System.out.println(subject.getId());
			System.out.println(subject.getDays());
			System.out.println(subject.getName());
		}
	}
}
