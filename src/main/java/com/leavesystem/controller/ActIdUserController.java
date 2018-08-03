package com.leavesystem.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.leavesystem.model.ActIdUser;
import com.leavesystem.service.ActIdUserService;
import com.leavesystem.util.CharacterUtils;
import com.leavesystem.util.GetSHA256StrUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@SessionAttributes("user")
@RequestMapping("/actIdUserController")
public class ActIdUserController {

	@Resource
	private ActIdUserService actIdUserServiceImpl;

	@Autowired
	private CharacterUtils characterUtils;
	@Autowired
	private GetSHA256StrUtils getSHA256StrUtils;

	public ActIdUserService getActIdUserServiceImpl() {
		return actIdUserServiceImpl;
	}

	public void setActIdUserServiceImpl(ActIdUserService actIdUserServiceImpl) {
		this.actIdUserServiceImpl = actIdUserServiceImpl;
	}

	//若是输入空值则为查询所有用户，设置为打开页面时刷新用
	//通过用户名查找用户
	@RequestMapping("/queryUserByactuserId")
	@ResponseBody
	public String queryUserByactuserId(HttpServletRequest request, HttpServletResponse response) {
		String actuserId = request.getParameter("username");
		List<ActIdUser> actIdUsers = actIdUserServiceImpl.findByLikeId(actuserId);//通过用户名查找
		JSONArray array = new JSONArray();
		for (ActIdUser actIdUser : actIdUsers) {
			String id = actIdUser.getId();
			String email = actIdUser.getEmail();
			String password = actIdUser.getPwd();
			JSONObject object = new JSONObject();
			object.put("id", id);
			object.put("email", email);
			object.put("password", password);
			array.add(object);
		}
		return array.toString();
	}

	//删除用户
	@RequestMapping("/deleteUserByactuserId")
	@ResponseBody
	public String deleteUserByactuserId(HttpServletRequest request, HttpServletResponse response) {
		String actuserIds = request.getParameter("orderList");
		String[] actuserIdArray = actuserIds.split(",");
		for (String actuserId : actuserIdArray) {
			//System.out.println(actuserId);
			actIdUserServiceImpl.deleteUser(actuserId);
		}
		JSONArray array = new JSONArray();
		return array.toString();
	}

	/*
	 * 跳转至用户更新
	 */
	@RequestMapping("toupdate")
	public String toupdate(@RequestParam("username") String username, Model model) {
		ActIdUser actIdUser = actIdUserServiceImpl.findById(username);
		System.out.println(actIdUser);
		String id = actIdUser.getId();
		String email = actIdUser.getEmail();
		model.addAttribute("id", id);
		model.addAttribute("email", email);
		System.out.println(id + email);
		return "updateUser";
	}

	//更新用户信息 
	@RequestMapping("/updateUserByactuser")
	public ModelAndView updateUserByactuser(String id, String pwd, ActIdUser user) {
		//System.out.println(user.toString());
		//生成随机值+密码
		String str = characterUtils.getRandomString(10);
		user.setLast(str);//将随机值存入数据库
		String newstr = str + pwd;
		String hashcode_pass = getSHA256StrUtils.getSHA256Str(newstr);//这里输入的是随机值+密码的字符串
		user.setPwd(hashcode_pass);
		int re = actIdUserServiceImpl.updateUser(user);
		ModelAndView modelAndView = new ModelAndView();
		if (re != 0) {
			// 指定逻辑视图名,跳转至成功
			modelAndView.setViewName("userManage");
			return modelAndView;
		}
		// 指定逻辑视图名，返回原网页
		modelAndView.setViewName("updateUser");
		return modelAndView;
	}

	//登录验证
	@RequestMapping("/login")
	public String login(String id, String pwd, Model model) {
		System.out.println(id);
		ActIdUser actIdUser = actIdUserServiceImpl.findById(id);
		if (actIdUser != null) {
			//System.out.println(pwd);
			String teststr = actIdUser.getLast() + pwd;//这里的是从数据库获取的随机值+密码的字符串
			//System.out.println(teststr);
			String testhashcode_pass = getSHA256StrUtils.getSHA256Str(teststr);//生成一个测试哈希值
			//System.out.println(testhashcode_pass);
			if (actIdUser.getPwd().equals(testhashcode_pass)) {
				model.addAttribute("user", actIdUser);//将actIdUser存入session
				// 指定逻辑视图名
				System.out.println("验证成功");
				model.addAttribute("user", actIdUser);
				// 指定逻辑视图名,跳转至成功
				return "index";
			} else {
				// 指定逻辑视图名
				System.out.println("验证失败");
				return "login";
			}

		} else {
			// 指定逻辑视图名
			System.out.println("验证失败");
			return "login";
		}

	}

	//注销
	@RequestMapping("logout")
	public String logout(@ModelAttribute("user") ActIdUser actIdUser, SessionStatus sessionStatus) {
		//@ModelAttribute("User")相当于将session中名为"User"的对象注入user对象中
		//sessionStatus中的setComplete方法可以将session中的内容全部清空
		sessionStatus.setComplete();
		return "login";
	}

	//注册程序
	@RequestMapping("/register")
	public ModelAndView register(String id, String pwd, ActIdUser user) {
		//生成随机值+密码
		String str = characterUtils.getRandomString(10);
		user.setLast(str);//将随机值存入数据库
		String newstr = str + pwd;
		String hashcode_pass = getSHA256StrUtils.getSHA256Str(newstr);//这里输入的是随机值+密码的字符串
		user.setPwd(hashcode_pass);
		int re = actIdUserServiceImpl.addUser(user);
		ModelAndView modelAndView = new ModelAndView();
		if (re != 0) {
			// 指定逻辑视图名,跳转至成功
			modelAndView.setViewName("index");
			return modelAndView;
		}
		// 指定逻辑视图名，返回原网页
		modelAndView.setViewName("register");
		return modelAndView;
	}

}
