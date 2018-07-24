package com.leavesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavesystem.mapper.UserMapper;
import com.leavesystem.model.User;
import com.leavesystem.model.UserExample;
import com.leavesystem.model.UserExample.Criteria;
import com.leavesystem.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override //登录，按照用户名和密码查找用户，返回User
	public List<User> testUser(String name) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		return userMapper.selectByExample(example);
	}

	@Override //注册，添加用户
	public int addUser(User user) {
		return userMapper.insert(user);
	}

	@Override //根据ID查找用户
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	/*public List<User> getUserNameByRiSy(int right, int system) {
		return userMapper.SelectUserByRiSy(right, system);
	}*/

	/*@Override
	public int updatePassword(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}*/

	/*@Override
	public int changeUser(User user) {
		return userMapper.updateByPrimaryKey(user);
	}*/

	/*public int resetPassword(String pass, String name) {
		return userMapper.resetPassword(pass, name);
	}*/

	/*
	@Override
	public int removeUser(int id) {
		return userMapper.deleteByPrimaryKey(id);
	}*/

}
