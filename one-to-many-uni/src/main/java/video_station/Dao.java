package video_station;

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
		VideoChapter chapter=new VideoChapter();
		chapter.setChapterNum(23);
		chapter.setName("JDBC");
		
		Video video=new Video();
		video.setNumber(111);
		video.setTitle("1st step");
		
		Video video2=new Video();
		video2.setNumber(122);
		video2.setTitle("1st step");
		
		List<Video> videos=Arrays.asList(video,video2);
		chapter.setVideos(videos);
		et.begin();
		em.persist(video);
		em.persist(video2);
		em.persist(chapter);
		et.commit();
		System.out.println("saved------!");
	}
	public void delete() {
		VideoChapter chapter=em.find(VideoChapter.class, 1);
		if(chapter != null) {
			et.begin();
			em.remove(chapter);
			et.commit();
			System.out.println("deleted------!");
		}
	}
	public void update() {
		VideoChapter chapter=em.find(VideoChapter.class, 1);
		if(chapter != null) {
			chapter.setName("2nd step");
			et.begin();
			em.merge(chapter);
			et.commit();
			System.out.println("updated------!");
		}
	}
	public void find() {
		VideoChapter chapter=em.find(VideoChapter.class, 1);
		if(chapter != null) {
			System.out.println(chapter.getChapterNum());
			System.out.println(chapter.getName());
			List<Video> videos=chapter.getVideos();
			for(Video video:videos) {
				System.out.println(video.getNumber());
				System.out.println(video.getTime());
			}
		}
	}
}
