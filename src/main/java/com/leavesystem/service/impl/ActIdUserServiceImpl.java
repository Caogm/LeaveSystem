package com.leavesystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavesystem.mapper.ActIdUserMapper;
import com.leavesystem.model.ActIdUser;
import com.leavesystem.service.ActIdUserService;

@Service("actIdUserServiceImpl")
public class ActIdUserServiceImpl implements ActIdUserService {

	@Autowired
	private ActIdUserMapper actIdUserMapper;

	public ActIdUserMapper getActIdUserMapper() {
		return actIdUserMapper;
	}

	public void setActIdUserMapper(ActIdUserMapper actIdUserMapper) {
		this.actIdUserMapper = actIdUserMapper;
	}

	@Override //注册，添加用户
	public int addUser(ActIdUser actuser) {
		return actIdUserMapper.insert(actuser);
	}

	@Override //根据ID查找,用户登录，按照用户名和密码查找用户，返回ActIdUser
	public ActIdUser findById(String actuserId) {
		return actIdUserMapper.selectByPrimaryKey(actuserId);
	}

	@Override
	public ActIdUser userLogin(ActIdUser actuser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActIdUser> userPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(List<String> actuserId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(ActIdUser actuser) {
		// TODO Auto-generated method stub
		return 0;
	}

}
