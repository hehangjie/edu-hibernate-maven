package edu.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.demo.model.User;

public class ConnectionTest {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = null;
		Transaction transaction = null;
		
		User user = new User();
		user.setUserId(98);
		user.setUserName("lenovo");
		user.setAge(23);

		try {
			// // add
			session = factory.openSession();
			transaction = session.beginTransaction();
			 session.clear();
			 session.save(user);
			 transaction.commit();

		} finally {
			session.close();
		}

	}
}
