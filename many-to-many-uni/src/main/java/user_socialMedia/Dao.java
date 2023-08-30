package user_socialMedia;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Embeddable;
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
		System.out.println("enter user id,name,phone");
		UserInfo user = new UserInfo();
		user.setId(sc.nextInt());
		user.setName(sc.next());
		user.setPhone(sc.nextLong());

		System.out.println("enter Social media id, name, type");
		SocialMedia socialMedia1 = new SocialMedia();
		socialMedia1.setId(sc.nextInt());
		socialMedia1.setName(sc.next());
		socialMedia1.setType(sc.next());

		System.out.println("enter Social media id, name, type");
		SocialMedia socialMedia2 = new SocialMedia();
		socialMedia2.setId(sc.nextInt());
		socialMedia2.setName(sc.next());
		socialMedia2.setType(sc.next());

		List<SocialMedia> socialMedias = Arrays.asList(socialMedia1, socialMedia2);
		user.setSocialMedias(socialMedias);
		et.begin();
		em.persist(user);
		em.persist(socialMedia1);
		em.persist(socialMedia2);
		et.commit();
		System.out.println("saved----------!");
	}

	public void delete() {
		System.out.println("enter the user id to delete");
		UserInfo user = em.find(UserInfo.class, sc.nextInt());
		if (user != null) {
			et.begin();
			em.remove(user);
			et.commit();
			System.out.println("deleted----------!");
		}
	}

	public void update() {
		System.out.println("enter the user id to update");
		UserInfo user = em.find(UserInfo.class, sc.nextInt());
		if (user != null) {
			System.out.println("enter the new phone");
			user.setPhone(sc.nextLong());
			et.begin();
			em.merge(user);
			et.commit();
			System.out.println("updated----------!");
		}
	}

	public void find() {
		System.out.println("enter id to fetch the user with social media");
		UserInfo user = em.find(UserInfo.class, sc.nextInt());

		if (user != null) {

			System.out.println("user id " + user.getId());
			System.out.println("user name " + user.getName());
			System.out.println("user phone " + user.getPhone());
			System.out.println("____________________________________");
			List<SocialMedia> socialMedias = user.getSocialMedias();
			for (SocialMedia s : socialMedias) {
				System.out.println("social media id " + s.getId());
				System.out.println("social media name " + s.getName());
				System.out.println("social media type " + s.getType());
			}
		}
	}

	public void findAll() {
		Query query = em.createQuery("select u from UserInfo u");
		List<UserInfo> userinfos = query.getResultList();
		for (UserInfo user : userinfos) {
			System.out.println("_________________USER_________________");
			System.out.println("user id " + user.getId());
			System.out.println("user name " + user.getName());
			System.out.println("user phone " + user.getPhone());
			List<SocialMedia> socialMedias = user.getSocialMedias();
			for (SocialMedia s : socialMedias) {
				System.out.println("**************social_media**************");
				System.out.println("social media id " + s.getId());
				System.out.println("social media name " + s.getName());
				System.out.println("social media type " + s.getType());
			}
		}
	}

	public void saveExistingSocialInUser() {
		System.out.println("enter the social media id ");
		SocialMedia socialMedia = em.find(SocialMedia.class, sc.nextInt());
		if (socialMedia != null) {

		}
	}

}
