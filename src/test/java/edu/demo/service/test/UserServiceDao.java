package edu.demo.service.test;

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
public class UserServiceDao {

	@Autowired
	private UserDao userDao;

	@Test
	public void testAdd() {
		int size = userDao.findList().size();

		User entity = new User();
		entity.setUserId(71);
		entity.setUserName("¶¼Ãô¿¡");
		entity.setAge(99);
		userDao.add(entity);

		int finalSize = userDao.findList().size();

		Assert.assertTrue(finalSize == size + 1);
	}

}
