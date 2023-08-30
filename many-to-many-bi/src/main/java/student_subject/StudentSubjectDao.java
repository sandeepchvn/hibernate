package student_subject;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentSubjectDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void save() {
		Student student = new Student();
		student.setId(5);
		student.setName("sandeep");
		student.setEmail("sa@gmail.com");

		Subject subject = new Subject();
		subject.setId(101);
		subject.setName("JAVA");
		subject.setDays(76);

		Subject subject2 = new Subject();
		subject2.setId(102);
		subject2.setName("JS");
		subject2.setDays(36);
//
//		List<Subject> subjects = Arrays.asList(subject, subject2);
//		student.setSubjects(subjects);

		List<Student> students = Arrays.asList(student);

		subject.setStudents(students);
		subject2.setStudents(students);

		et.begin();
		em.persist(student);
		em.persist(subject);
		em.persist(subject2);
		et.commit();
		System.out.println("saved----------!");
	}
	public void find() {
		Student student=em.find(Student.class, 1);
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getEmail());
		System.out.println("----------------------------");
		List<Subject> subjects=student.getSubjects();
		for(Subject subject:subjects) {
			System.out.println(subject.getId());
			System.out.println(subject.getName());
			System.out.println(subject.getDays());
		}
	}
}
