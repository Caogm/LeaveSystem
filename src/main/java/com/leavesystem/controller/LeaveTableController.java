package com.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leavesystem.model.LeaveTable;
import com.leavesystem.service.LeaveTableService;

@Controller
@RequestMapping("/leaveTableController")
public class LeaveTableController {

	@Autowired
	private LeaveTableService leaveTableServiceImpl;

	public LeaveTableService getLeaveTableService() {
		return leaveTableServiceImpl;
	}

	public void setLeaveTableService(LeaveTableService leaveTableServiceImpl) {
		this.leaveTableServiceImpl = leaveTableServiceImpl;
	}

	//新增请假单
	@RequestMapping("/addLeaveTable")
	public void addLeaveTable(LeaveTable leavetable) {
		leaveTableServiceImpl.addLeaveTable(leavetable);
	}

	//根据用户名查找
	@RequestMapping("/queryByName")
	private String queryByName(String uname) {
		leaveTableServiceImpl.queryByName(uname);
		return "homepage";
	}

	//根据模糊条件查询所有请假单
	@RequestMapping("/queryLeaveTable")
	public String queryLeaveTable(String leavetype, String reason, Model model) {
		List<LeaveTable> leaveTables = leaveTableServiceImpl.queryByStr(leavetype, reason);
		for (LeaveTable leaveTable : leaveTables) {
			System.out.println(leaveTable);
		}
		model.addAttribute("leavetables", leaveTables);
		return "homepage";
	}

	/*@RequestMapping("/queryLeaveTable")
	public String queryLeaveTable(String leavetype) {
		List<LeaveTable> leaveTables = leaveTableServiceImpl.queryByStr(leavetype);
		return "homepage";
	}*/

	//修改请假单
	@RequestMapping("/updateLeaveTable")
	public void updateLeaveTable() {
		//leaveTableServiceImpl.updateLeaveTable(id, leavetable);
	}

	//删除请假单
	@RequestMapping("/deleteLeaveTable")
	public void deleteLeaveTable() {

	}
}
