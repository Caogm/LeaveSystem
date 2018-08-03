package com.leavesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.IdentityService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//identityServiceImpl.saveUser(new UserEntity(userId));//建立用户
/*
 *表结构介绍
 *act_id_group：角色组表
 *act_id_user：用户表：
 *act_id_membership：用户角色表
	
 */

@Controller
@RequestMapping("/MembershipController")
public class UserMembershipController {

	@Resource
	private IdentityService identityServiceImpl;
	@Resource
	private TaskService taskServiceImpl;

	/*
	 * 查询用户和组关系
	 */
	@RequestMapping("/queryMembership")
	@ResponseBody
	public String queryMembership(HttpServletRequest request, HttpServletResponse response) {
		String query = request.getParameter("query");
		System.out.println(query);
		List<Group> userlist = identityServiceImpl.createGroupQuery().groupNameLike(query).list();
		for (Group group : userlist) {
			System.out.println("-------" + group);
		}
		return null;
	}

	/*
	 * 添加用户和组的关联关系
	 */
	@RequestMapping("/setMembership")
	@ResponseBody
	public void setMembership(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("actuserId");
		String userpost = request.getParameter("post");
		System.out.println(userId + userpost);
		/**在部署流程定义和启动流程实例的中间，设置组任务的办理人，向Activiti表中存放组和用户的信息*/
		switch (userpost) {
		case "employee":
			identityServiceImpl.createMembership(userId, "employee");//建立组和用户关系
			break;
		case "project manager":
			identityServiceImpl.createMembership(userId, "project manager");//建立组和用户关系
			break;
		case "HR":
			identityServiceImpl.createMembership(userId, "HR");//建立组和用户关系
			break;
		case "CEO":
			identityServiceImpl.createMembership(userId, "CEO");//建立组和用户关系
			break;
		default:
			identityServiceImpl.saveGroup(new GroupEntity(userpost));//建立组
			identityServiceImpl.createMembership(userId, userpost);//建立组和用户关系
			break;
		}

	}

	/*
	 * 删除用户和组的关系
	 */
	@RequestMapping("/deleteMembership")
	@ResponseBody
	public void deleteMembership(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("actuserId");
		String userpost = request.getParameter("post");
		System.out.println(userId + userpost);
		identityServiceImpl.deleteMembership(userId, userpost);
	}

	/*
	 * 删除用户组
	 */
	@RequestMapping("/deleteGroup")
	@ResponseBody
	public void deleteGroup(HttpServletRequest request, HttpServletResponse response) {
		String userpost = request.getParameter("post");
		System.out.println(userpost);
		identityServiceImpl.deleteGroup(userpost);
	}
}
