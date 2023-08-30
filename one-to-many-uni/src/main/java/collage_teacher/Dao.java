package collage_teacher;

import java.util.ArrayList;
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
		Collage collage=new Collage();
		collage.setId(7);
		collage.setName("vxv");
		
		Teacher teacher=new Teacher();
		teacher.setId(111);
		teacher.setName("bam");
		
		Teacher teacher1=new Teacher();
		teacher1.setId(112);
		teacher1.setName("dum");
//		Teacher teacher=em.find(Teacher.class, 111);
		List<Teacher> teachers=new ArrayList<Teacher>();
		teachers.add(teacher);
		teachers.add(teacher1);
		
		collage.setTeachers(teachers);
		
		et.begin();
		em.merge(teacher);
		em.persist(teacher1);
		em.persist(collage);
		et.commit();
		System.out.println("saved---------!");
	}
	public void delete() {
		Collage collage=em.find(Collage.class, 1);
		if(collage != null) {
			et.begin();
			em.remove(collage);
			et.commit();
			System.out.println("deleted--------!");
		}
	}
	public void update() {
		Collage collage=em.find(Collage.class, 1);
		if(collage != null) {
			collage.setName("MVC");
			et.begin();
			em.merge(collage);
			et.commit();
			System.out.println("deleted--------!");
		}
	}
	public void find() {
		Collage collage=em.find(Collage.class, 1);
		if(collage != null) {
			System.out.println(collage.getId());
			System.out.println(collage.getName());
			List<Teacher> teachers=collage.getTeachers();
			for(Teacher teacher:teachers) {
				System.out.println(teacher.getId());
				System.out.println(teacher.getName());
				System.out.println(teacher.getSubject());
			}
			System.out.println(collage.getId());
		}
	}
}
