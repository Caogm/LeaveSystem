package com.leavesystem.service;

import java.util.List;
import java.util.Map;

import com.leavesystem.model.ActIdUser;

public interface ActIdUserService {

	public ActIdUser findById(String actuserId);

	public ActIdUser userLogin(ActIdUser actuser);

	public List<ActIdUser> userPage(Map<String, Object> map);

	public int userCount(Map<String, Object> map);

	public int deleteUser(List<String> actuserId);

	public int updateUser(ActIdUser actuser);

	public int addUser(ActIdUser actuser);

}
