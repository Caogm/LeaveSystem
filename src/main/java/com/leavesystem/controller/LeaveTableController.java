package com.leavesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.leavesystem.model.ActIdUser;
import com.leavesystem.model.LeaveTable;
import com.leavesystem.service.LeaveTableService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@SessionAttributes("user")
@RequestMapping("/leaveTableController")
public class LeaveTableController {

	@Autowired
	private LeaveTableService leaveTableServiceImpl;

	@Resource
	private TaskService taskServiceImpl;

	//新增请假单
	@RequestMapping("/addLeaveTable")
	public String addLeaveTable(LeaveTable leavetable) {
		leaveTableServiceImpl.addLeaveTable(leavetable);
		return "table-list";
	}

	//根据模糊条件查询所有请假单
	@RequestMapping("/queryLeaveTableAll")
	@ResponseBody
	public String queryLeaveTableAll(@ModelAttribute("user") ActIdUser user, HttpServletRequest request,
			HttpServletResponse response) {
		String reason = request.getParameter("reason");
		JSONArray array = new JSONArray();
		List<LeaveTable> leaveTables = leaveTableServiceImpl.queryByLikeReason(reason);
		for (LeaveTable leaveTable : leaveTables) {
			//System.out.println(leaveTable);
			Integer id = leaveTable.getId();
			String uname = leaveTable.getUname();
			String reasons = leaveTable.getReason();
			String createtime = leaveTable.getCreatetime().toString();
			String state = leaveTable.getState();
			JSONObject object = new JSONObject();
			object.put("id", id);
			object.put("uname", uname);
			object.put("reasons", reasons);
			object.put("createtime", createtime);
			object.put("state", state);
			array.add(object);
		}
		return array.toString();
	}

	//根据请假类型+模糊条件查询所有请假单
	@RequestMapping("/queryLeaveTable")
	@ResponseBody
	public String queryLeaveTable(@ModelAttribute("user") ActIdUser user, HttpServletRequest request,
			HttpServletResponse response) {
		String leavetype = request.getParameter("leavetype");
		String reason = request.getParameter("reason");
		//System.out.println(leavetype + reason);
		JSONArray array = new JSONArray();
		List<LeaveTable> leaveTables = leaveTableServiceImpl.queryByStr(leavetype, reason);
		for (LeaveTable leaveTable : leaveTables) {
			//System.out.println(leaveTable);
			String uname = leaveTable.getUname();
			String reasons = leaveTable.getReason();
			String createtime = leaveTable.getCreatetime().toString();
			String state = leaveTable.getState();
			JSONObject object = new JSONObject();
			object.put("uname", uname);
			object.put("reasons", reasons);
			object.put("createtime", createtime);
			object.put("state", state);
			array.add(object);
		}
		return array.toString();
	}

	//跳转至修改请假单
	@RequestMapping("/updateEditLeaveTable")
	public String updateEditLeaveTable(@RequestParam("leaveId") Integer leaveId, Model model) {
		//leaveTableServiceImpl.updateLeaveTable(leaveId, leavetable);
		LeaveTable leaveTable = leaveTableServiceImpl.queryById(leaveId);

		model.addAttribute("leaveTable", leaveTable);
		return "table-update";
	}

	//修改请假单
	@RequestMapping("/updateLeaveTable")
	public String updateLeaveTable(Integer id, LeaveTable leavetable, Model model) {
		//System.out.println(leaveId);
		System.out.println(leavetable);
		//Integer id = leavetable.getId();
		Task task = taskServiceImpl.createTaskQuery().processInstanceId(leavetable.getProcessinstance()).singleResult();
		String taskId = task.getId();
		System.out.println(taskId);
		model.addAttribute("taskId", taskId);
		leaveTableServiceImpl.updateLeaveTable(id, leavetable);
		return "table-update";
	}

	//删除请假单
	@RequestMapping("/deleteLeaveTable")
	public void deleteLeaveTable(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("orderlist");
		System.out.println(uname);
		String[] unames = uname.split(",");
		for (String string : unames) {
			leaveTableServiceImpl.deleteLeaveTableByUname(string);
		}
	}
}
