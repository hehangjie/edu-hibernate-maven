package edu.demo.dao;

import org.springframework.stereotype.Repository;

import edu.common.dao.BaseDao;
import edu.demo.model.User;

@Repository
public class UserDao extends BaseDao<User, Integer> {

}
