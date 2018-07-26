package com.leavesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 流程定义管理
 * 
 */
@Controller
@RequestMapping("/processDefinitionController")
public class ProcessDefinitionController {
	@Resource
	private RepositoryService repositoryService;
	@Resource
	private HistoryService historyService;

	@RequestMapping("/searchProcessDefinition")
	@ResponseBody
	public String processDefinitionPage(HttpServletRequest request, HttpServletResponse response) {
		String pdname = request.getParameter("pdname");
		System.out.println(pdname);
		JSONArray array = new JSONArray();
		List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
				.orderByDeploymentId().desc().processDefinitionNameLike("%" + pdname + "%")//模糊查询并排序
				.list();
		for (ProcessDefinition processDefinition : processDefinitionList) {
			System.out.println(processDefinition);
			String id = processDefinition.getId();//流程定义ID
			String name = processDefinition.getName();//流程名称
			String key = processDefinition.getKey();//流程定义key
			System.out.println(id + "-----" + name + "-----" + key);
			int version = processDefinition.getVersion();//流程版本
			String resname = processDefinition.getResourceName();//流程定义的bpmn名称
			String dresname = processDefinition.getDiagramResourceName();//流程定义的bpmn名称
			String did = processDefinition.getDeploymentId();//获取流程部署ID
			JSONObject obj = new JSONObject();
			obj.put("id", id);
			obj.put("name", name);
			obj.put("key", key);
			obj.put("version", version);
			obj.put("resname", resname);
			obj.put("dresname", dresname);
			obj.put("did", did);
			array.add(obj);
		}
		return array.toString();
	}

}
