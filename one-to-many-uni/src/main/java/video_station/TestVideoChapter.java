package video_station;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestVideoChapter {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		 // 1st table
		VideoChapter vc=new VideoChapter();
		vc.setChapterNum(1);
		vc.setName("chapter");
		
		//2nd table
		Video v=new Video();
		v.setNumber(1);
		v.setTitle("hibernate intro");
		v.setTime("10:03 minutes");
		
		Video v2=new Video();
		v2.setNumber(2);
		v2.setTitle("hibernate dependency");
		v.setTime("19:03 minutes");
		
		//assigning video to VideoChapter
		List<Video> videos=new ArrayList<Video>();
		videos.add(v);
		videos.add(v2);
		vc.setVideos(videos);
		
		et.begin();
		em.persist(vc);
		em.persist(v);
		em.persist(v2);
		et.commit();
		System.out.println("Saved!---");
	}
}
