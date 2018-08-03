package com.leavesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leavesystem.model.LeaveTable;
import com.leavesystem.service.LeaveTableService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 请假业务管理控制
 */

@Controller
@RequestMapping("/leaveController")
public class LeaveController {

	@Resource
	private RuntimeService runtimeServiceImpl;
	@Resource
	private TaskService taskServiceImpl;
	@Resource
	private LeaveTableService leaveTableServiceImpl;

	//设置key的session
	@RequestMapping("/setsessionkey")
	public void setsessionkey(@RequestParam("key") String key, Model model) {
		System.out.println(key);
		model.addAttribute("key", key);
	}

	/*
	 * 提交请假流程申请
	 * 启动请假流程实例--根据流程实例ID查询任务----完成申请任务
	 * 数据库变化：act_ru_task：运行时变量表  act_ru_execution：运行时流程执行实例  act_hi_identitylink：运行时用户关系实例
	 */
	@RequestMapping("startLeaveFlow")
	public void startLeaveFlow(HttpServletRequest request, HttpServletResponse response) {
		/** 
		 * 启动请假单流程  并获取流程实例 
		 * 因为该请假单流程可以会启动多个所以每启动一个请假单流程都会在数据库中插入一条新版本的流程数据 
		 * 通过key启动的流程就是当前key下最新版本的流程 
		 *  
		 */

		/*System.out.println(request.getSession().getAttribute("key"));*/
		String key = "MyLeaveSystem";
		String ids = request.getParameter("orderlist");
		System.out.println(ids);
		Integer id = Integer.valueOf(ids);
		LeaveTable leavetable = leaveTableServiceImpl.queryById(id);//通过ID查找请假单
		System.out.println(leavetable);
		ProcessInstance processInstance = runtimeServiceImpl.startProcessInstanceByKey(key);//返回一个流程实例对象
		System.out.println("id:" + processInstance.getId() + "ac tivitiId:" + processInstance.getActivityId());
		String processInstanceId = processInstance.getProcessInstanceId();//生成流程实例ID
		//根据流程实例ID查询任务
		Task task = taskServiceImpl.createTaskQuery().processInstanceId(processInstanceId).singleResult();
		System.out.println("任务ID" + task.getId());
		taskServiceImpl.complete(task.getId());//完成请假申请任务

		leavetable.setState("审核中");
		leavetable.setProcessinstance(processInstanceId);//向数据库中写入processInstance
		leaveTableServiceImpl.updateLeaveTable(id, leavetable);
	}

	/*
	 * 查询用户任务
	 * 
	 */
	@RequestMapping("/queryTask")
	@ResponseBody
	public String queryTask() {
		String assignee = "测试2";
		//获取任务服务对象
		List<Task> tasks = taskServiceImpl.createTaskQuery()//通过任务服务实例创建任务查询获取TaskQuery对象
				.taskAssignee(assignee)
				//.taskCandidateUser(assignee)//TaskQuery对象调用taskAssignee（任务代理人）方法
				.list();//获取该代理人的任务
		System.out.println("---------------" + tasks);
		JSONArray array = new JSONArray();
		for (Task task : tasks) {

			System.out.println("ID:" + task.getId() + ",任务名称:" + task.getName() + ",接收群组:" + task.getCategory()
					+ ",开始时间:" + task.getCreateTime());
			String id = task.getId();//任务id
			String name = task.getName();//任务名称
			String assignees = task.getAssignee();//任务当前代理人

			String createtime = task.getCreateTime().toString();//任务创建时间
			JSONObject object = new JSONObject();
			object.put("id", id);
			object.put("name", name);
			object.put("assignee", assignee);
			object.put("createtime", createtime);
			array.add(object);

		}
		return array.toString();
	}

	/*
	 * 删除流程实例
	 */
	@RequestMapping("/delete")
	public void delete() {
		runtimeServiceImpl.deleteProcessInstance("42501", "删除");
	}
}
