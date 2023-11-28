package food_app.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import food_app.dto.Userr;

class UserrDaoTest {
private UserrDao dao;
//	@BeforeEach
//	public  void beforeAllTest() {
//		dao=new UserrDao();
//	}
	
	@Test
	void testSave() {
		JunitUserDao dao=new JunitUserDao();
		Userr user=new Userr();
		user.setId(104);
		user.setName("ABC");
		user.setEmail("abc@gmaio.com");
		user.setPassword("123");
		Userr u=dao.saveUser(user);
		Assertions.assertTrue(u.getId() == user.getId());
	}
	@Test
	void testFindUser() {
		JunitUserDao dao=new JunitUserDao();
		Userr u=dao.findUser(101);
		Assertions.assertTrue(u.getId() > 0);
	}
	@Test
	void testdeleteUser() {
		JunitUserDao dao=new JunitUserDao();
		Assertions.assertTrue(dao.deleteUser(103));
	}
	@Test
	void testupdateUser() {
		JunitUserDao dao=new JunitUserDao();
		Userr u=dao.updateUser(104, "cba@gmail.com");
		Assertions.assertTrue(u.getEmail().equals("cba@gmail.com"));
	}
//	@AfterEach
//	public  void afterAllTest() {
//		dao.em.close();
//	}
}
