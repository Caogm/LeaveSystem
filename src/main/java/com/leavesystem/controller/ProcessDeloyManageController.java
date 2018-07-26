package com.leavesystem.controller;

import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 流程部署管理
 */
@Controller
@RequestMapping("/deployController")
public class ProcessDeloyManageController {
	@Resource //注入activitiService服务
	private RepositoryService repositoryService;

	/*
	 * 查询部署流程
	 */
	@RequestMapping("/querydeploy")
	@ResponseBody //使用ajax传递参数到控制层
	public String querydeploy(HttpServletRequest request, HttpServletResponse response) {
		String pdmname = request.getParameter("pdmname");
		System.out.println(pdmname);
		JSONArray array = new JSONArray();
		List<Deployment> deployList = repositoryService.createDeploymentQuery().orderByDeploymenTime().desc()//按时间降序
				.deploymentNameLike("%" + pdmname + "%")//根据name模糊查询
				.list();
		for (Deployment deployment : deployList) {
			System.out.println(deployment);
			String id = deployment.getId();
			String name = deployment.getName();
			String date = deployment.getDeploymentTime().toString();
			JSONObject obj = new JSONObject();
			obj.put("id", id);
			obj.put("name", name);
			obj.put("date", date);
			array.add(obj);
		}
		//如何将值返回到jsp页面上

		return array.toString();
	}

	/**
	 * 添上传流程部署ZIP文件
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/addDeploy")
	public String addDeploy(@RequestParam("file") MultipartFile file) throws Exception {
		repositoryService.createDeployment() //创建部署
				.name(file.getOriginalFilename()) //需要部署流程名称
				.addZipInputStream(new ZipInputStream(file.getInputStream()))//添加ZIP输入流
				.deploy();//开始部署

		return null;
	}

}
