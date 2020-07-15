package ecommerce.user.service;

import java.util.ArrayList;

import ecommerce.user.dao.UserDaoImpl;
import ecommerce.user.model.UserBean;

public class UserService {
	private UserDaoImpl userDao;
	public UserService() {
		userDao = new UserDaoImpl();
	}
	public boolean addUser(UserBean user) {
		return userDao.addUser(user);
	}

	public boolean deleteUser(String username) {
		return userDao.deleteUser(username);
	}

	
	public boolean updateUserByUsername(UserBean user) {
		return userDao.updateUserByUsername(user);	
	}

	public UserBean getUserByUsername(String username) {
		return userDao.getUserByUsername(username);	
	}

	public ArrayList<UserBean> getAllUser() {
		return userDao.getAllUser();	
	}
	
	
	public UserDaoImpl getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	@Override
	public String toString() {
		return "UserService [userDao=" + userDao + "]";
	}
	

}

