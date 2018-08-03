package com.leavesystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.identity.Group;
import org.activiti.engine.task.Task;
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
@RequestMapping("/taskController")
public class TaskController {
	@Resource
	private RuntimeService runtimeServiceImpl;

	@Resource
	private TaskService taskServiceImpl;

	@Resource
	private FormService FormServiceImpl;

	@Resource
	private IdentityService identityServiceImpl;

	@Resource
	private LeaveTableService leaveTableServiceImpl;

	@Resource
	private HistoryService historyServiceImpl;

	/*
	 * 任务管理，查询登录人历史任务queryfinshedtask.jsp
	 */
	@RequestMapping("/queryfinshedtask")
	@ResponseBody
	public String queryfinshedtask(@ModelAttribute("user") ActIdUser user) {
		String assignee = user.getId();//通过session获取登录用户ID即为membership表中的userID
		Group group = identityServiceImpl.createGroupQuery().groupMember(assignee).singleResult();//获取userID所在的组
		String candidateGroup = group.getId();//获取组别ID
		System.out.println(candidateGroup);
		List<HistoricTaskInstance> historicTaskInstances = historyServiceImpl.createHistoricTaskInstanceQuery()
				.taskCandidateGroup(candidateGroup).list();
		System.out.println(historicTaskInstances);
		JSONArray array = new JSONArray();
		for (HistoricTaskInstance historicTaskInstance : historicTaskInstances) {
			String id = historicTaskInstance.getId();
			String name = historicTaskInstance.getName();
			String ProcessInstanceId = historicTaskInstance.getProcessInstanceId();
			String cretetime = historicTaskInstance.getCreateTime().toString();
			String endtime = historicTaskInstance.getEndTime().toString();
			/*LeaveTable leave = leaveTableServiceImpl.queryByProcessInstanceId(ProcessInstanceId);
			String uname = leave.getUname();*/
			//System.out.println(id + "---" + name + "---" + ProcessInstanceId + "---" + cretetime + "---" + endtime);
			JSONObject object = new JSONObject();
			object.put("id", id);
			object.put("name", name);
			//object.put("uname", uname);
			object.put("ProcessInstanceId", ProcessInstanceId);
			object.put("cretetime", cretetime);
			object.put("endtime", endtime);
			array.add(object);
		}
		return array.toString();
	}

	/*
	 * 待办任务管理，查询登录人当前任务unfinished-task.jsp
	 */
	@RequestMapping("/queryUnfinshTask")
	@ResponseBody
	public String queryUnfinshTask(@ModelAttribute("user") ActIdUser user) {
		String assignee = user.getId();//通过session获取登录用户ID即为membership表中的userID
		Group group = identityServiceImpl.createGroupQuery().groupMember(assignee).singleResult();//获取userID所在的组
		String candidateGroup = group.getId();//获取组别ID
		System.out.println(candidateGroup);
		//String candidateGroup = "project manager";
		//根据接收人所在组获取该用户的任务
		List<Task> tasks = taskServiceImpl.createTaskQuery().taskCandidateGroup(candidateGroup).list();
		JSONArray array = new JSONArray();
		for (Task task : tasks) {
			String taskID = task.getId();
			String taskName = task.getName();
			String taskCreateTime = task.getCreateTime().toString();
			System.out.println("任务ID：" + task.getId() + "任务名称" + task.getName() + "任务创建时间" + task.getCreateTime());
			JSONObject object = new JSONObject();
			object.put("taskID", taskID);
			object.put("taskName", taskName);
			object.put("taskCreateTime", taskCreateTime);
			array.add(object);
		}
		return array.toString();
	}

	/*
	 * 跳转任务审批approvetask.jsp
	 */
	@RequestMapping("/handletask")
	public String handletask(@RequestParam("taskId") String taskId, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		//String taskid = request.getParameter(taskId);//("orderList")
		System.out.println(taskId);
		Task task = taskServiceImpl.createTaskQuery().taskId(taskId).singleResult();
		System.out.println(task.toString());
		String ProcessInstanceId = task.getProcessInstanceId();
		List<LeaveTable> leaves = leaveTableServiceImpl.queryByProcessInstanceId(ProcessInstanceId);
		for (LeaveTable leave : leaves) {
			System.out.println(leave);
			model.addAttribute("leave", leave);
			model.addAttribute("taskId", taskId);
			model.addAttribute("ProcessInstanceId", ProcessInstanceId);
		}

		return "approvetask";
	}

	/*
	 * 任务审批
	 */
	@RequestMapping("/finshtask")
	@ResponseBody
	public String finshtask(String userId, Integer leaveId, String taskId, String opinion, Integer statuscode) {
		Map<String, Object> variables = new HashMap<String, Object>();
		System.out.println(taskId);
		System.out.println(statuscode);

		String assignee = userId;//通过session获取登录用户ID即为membership表中的userID
		Group group = identityServiceImpl.createGroupQuery().groupMember(assignee).singleResult();//获取userID所在的组
		String candidateGroup = group.getId();//获取组别ID
		System.out.println(candidateGroup);

		LeaveTable leaveTable = leaveTableServiceImpl.queryById(leaveId);
		System.out.println(leaveTable);
		Task task = taskServiceImpl.createTaskQuery().taskId(taskId).singleResult();
		System.out.println(task);
		String ProcessInstanceId = task.getProcessInstanceId();

		if (candidateGroup.equals("CEO")) {
			if (statuscode == 1) {
				variables.put("msg", "通过");
				leaveTable.setState("审核通过");
			} else {
				variables.put("msg", "未通过");
				leaveTable.setState("审核未通过");
			}
		} else {
			if (statuscode == 1) {
				variables.put("msg", "通过");
				leaveTable.setState("审核中");
			} else {
				variables.put("msg", "未通过");
				leaveTable.setState("审核未通过");
			}
		}

		leaveTableServiceImpl.updateLeaveTable(leaveId, leaveTable);
		taskServiceImpl.addComment(taskId, ProcessInstanceId, opinion);
		taskServiceImpl.complete(taskId, variables);
		return "index";//返回到首页
	}

}
