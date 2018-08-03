package com.leavesystem.controller;

import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.leavesystem.model.ActIdUser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * 流程部署资源管理,发布流程、删除流程
 * 部署流程结束后数据库有如下变化
 * act_ge_bytearray：通用的流程定义和流程资源
 * act_re_deployment：部署单元信息
 * act_re_procdef：已部署的流程定义
 * 
 */
@Controller
@SessionAttributes("user")
@RequestMapping("/deployController")
public class ProcessDeloyManageController {
	@Resource //注入activitiService服务
	private RepositoryService repositoryService;

	/*
	 * 查询部署流程定义信息
	 */
	@RequestMapping("/querydeploy")
	@ResponseBody //使用ajax传递参数到控制层
	public String querydeploy(@ModelAttribute("user") ActIdUser user, HttpServletRequest request,
			HttpServletResponse response) {
		String pdmname = request.getParameter("pdmname");
		System.out.println(pdmname);
		JSONArray array = new JSONArray();
		List<Deployment> deployList = repositoryService.createDeploymentQuery()//创建流程定义查询对象
				.orderByDeploymenTime().desc()//按时间降序
				.deploymentNameLike("%" + pdmname + "%")//根据name模糊查询
				.list();//执行查询获取流程定义明细 
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

		return "processDeployManage";
	}

	/**
	 *删除部署流程
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/delDeploy")
	@ResponseBody
	public String delDeploy(HttpServletRequest request, HttpServletResponse response, String deploymentIds)
			throws Exception {
		String dIds = request.getParameter("orderList");//获取前台上传的ID进行删除流程部署
		String[] deploymentId = dIds.split(",");//按照，进行分割字符串
		for (String id : deploymentId) {
			//System.out.println(id);
			repositoryService.deleteDeployment(id, true);
		}
		JSONArray array = new JSONArray();
		return array.toString();
	}
}
