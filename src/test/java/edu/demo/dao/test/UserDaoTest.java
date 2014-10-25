package edu.demo.dao.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.demo.dao.UserDao;
import edu.demo.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class UserDaoTest {
	@Autowired
	private UserDao userDao;

	// @Before
	// public void setUp() throws Exception {
	// }
	//
	// @After
	// public void tearDown() throws Exception {
	// }

	@Test
	public void testFindList() {
		List<User> list = userDao.findList();

		for (User user : list) {
			System.out.println(user.getUserName());
		}
	}

	@Test
	public void testAdd() {
		List<User> list = userDao.findList();
		int size = list.size();
		User user = new User();
		user.setUserId(77);
		user.setUserName("¿Ó");
		user.setAge(31);
		userDao.add(user);
		list = userDao.findList();
		int finalSize = list.size();
		Assert.assertTrue(finalSize == size + 1);
	}

}
