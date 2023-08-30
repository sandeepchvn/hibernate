package university_student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Dao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in);

	public void save() {
		University university = new University();
		System.out.println("enter the University id,name,Phone,location");
		university.setId(sc.nextLong());
		university.setName(sc.next());
		university.setPhoneNumber(sc.nextLong());
		university.setLocation(sc.next());
		System.out.println("enter the Student id,name,phone,email");
		Student student = new Student();
		student.setId(sc.nextLong());
		student.setName(sc.next());
		student.setPhoneNumber(sc.nextLong());
		student.setEmail(sc.next());
		System.out.println("enter the Student id,name,phone,email");
		Student student1 = new Student();
		student1.setId(sc.nextLong());
		student1.setName(sc.next());
		student1.setPhoneNumber(sc.nextLong());
		student1.setEmail(sc.next());
		
		List<Student> students=new ArrayList<Student>();
		students.add(student);
		students.add(student1);
		
		university.setStudents(students);
		et.begin();
		em.persist(university);
		em.persist(student);
		em.persist(student1);
		et.commit();
		System.out.println("done---------!");
	}
	public void deleteStudent() {
		System.out.println("enter the id to delete the Student");
		long id=sc.nextLong();
		Student student=em.find(Student.class, id);
		Query query=em.createQuery("select u from University u where u.students.id=?1");
		query.setParameter(1, id);
		List<University> university=query.getResultList();
		for(University u:university) {
			u.setStudents(null);
			em.remove(student);
		System.out.println("done-----------!");
			}
//		Student student=em.find(Student.class, sc.nextLong());
//		University university=new  University();
////		university.setStudents(student);
////		Query query=em.createQuery("select u from University u where u.students=?1");
//		
//		List<University> universities=query.getResultList();
		
	//	University university=em.find(University.class, sc.nextLong());
//		for(University u:universities) {
//		if(u != null) {
//			et.begin();
//			em.remove(u.);
//			//em.remove(student);
//			et.commit();
//			System.out.println("deleted------!");
//		}
//		else
//			System.out.println("id is wrong");
//		}
	}
	public void findStudent() {
		System.out.println("enter the id to find the Student");
		Student student=em.find(Student.class, sc.nextLong());
		if(student != null) {
			System.out.println("Id "+student.getId());
			System.out.println("Name "+student.getName());
			System.out.println("phone "+student.getPhoneNumber());
			System.out.println("Email "+student.getEmail());
			
		}
		else
			System.out.println("id is wrong");
	}
	public void updatestudent() {
		System.out.println("enter the id to update the Student");
		Student student=em.find(Student.class, sc.nextLong());
		if(student != null) {
			System.out.println("enter the new id ");
			student.setPhoneNumber(sc.nextLong());
			et.begin();
			em.merge(student);
			et.commit();
			System.out.println("updated------!");
		}
		else
			System.out.println("id is wrong");
	}
	public void deleteUniverity() {
		System.out.println("enter the id to delete the universty");
		University university=em.find(University.class, sc.nextLong());
		if(university != null) {
			et.begin();
			em.remove(university);
			et.commit();
			System.out.println("deleted------!");
		}
		else
			System.out.println("id is wrong");
	}
	public void findStudentByUniversity() {
		System.out.println("enter the University id");
		University university=em.find(University.class, sc.nextLong());
		List<Student> students=university.getStudents();
		System.out.println("enter the student id to get Student Name ");
		long sid=sc.nextLong();
		for(Student student:students) {
			if(student.getId()==sid) {
				System.out.println("Name "+student.getName());
			}
			
		}
	}
}
