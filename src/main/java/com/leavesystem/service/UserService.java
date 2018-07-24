package com.leavesystem.service;

import java.util.List;

import com.leavesystem.model.User;

public interface UserService {

	List<User> testUser(String name);

	User getUserById(int id);

	int addUser(User users);

	/*List<User> getUserNameByRiSy(int right, int system);*/

	/*int updatePassword(String pass, int id);*/

	//int changeUser(User user);

	/*int resetPassword(String pass, String name);*/

	//int removeUser(int id);
}
