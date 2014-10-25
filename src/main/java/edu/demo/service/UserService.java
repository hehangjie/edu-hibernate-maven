package edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.demo.dao.UserDao;
import edu.demo.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> findList() {
		return userDao.findList();
	}

	public User get(Integer userId) {
		return userDao.get(userId);
	}

	public void add(User user) {
		userDao.add(user);
	}

	public void delete(Integer userId) {
		userDao.delete(userId);
	}

	public void update(User user) {
		userDao.update(user);
	}
}
