package edu.demo.dao.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.demo.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class ConnectionTest {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Before
	public void setUp() throws Exception {
		session = sessionFactory.openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void test() {
		String hql = "from User WHERE userId=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, 98);
		User demo = (User) query.list().get(0);
		System.out.println(demo.getUserName());
	}

}
