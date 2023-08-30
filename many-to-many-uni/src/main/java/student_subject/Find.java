package student_subject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Find {
public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	
	Student student=em.find(Student.class, 1);
	List<Subject> subjects=student.getSubjects();
	
	System.out.println("student id "+student.getId());
	System.out.println("student name "+student.getName());
	System.out.println("student email "+student.getEmail());
	System.out.println("___________________-");
	for(Subject s:subjects) {
		System.out.println(".......................");
		System.out.println("subject id "+s.getId());
		System.out.println("subject name "+s.getName());
		System.out.println("subject days "+s.getDays());
	}
}
}
