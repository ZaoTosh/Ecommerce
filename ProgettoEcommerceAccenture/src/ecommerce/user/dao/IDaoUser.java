package ecommerce.user.dao;

import java.util.ArrayList;

import ecommerce.user.model.UserBean;


public interface IDaoUser {

	public boolean addUser(UserBean user);
	public boolean deleteUser(String username);
	public boolean updateUserByUsername(UserBean user);
	public UserBean getUserByUsername(String username);
	public ArrayList<UserBean> getAllUser();
	
}