package com.leavesystem.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leavesystem.model.ActIdUser;
import com.leavesystem.service.ActIdUserService;
import com.leavesystem.util.CharacterUtils;
import com.leavesystem.util.GetSHA256StrUtils;

@Controller
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

	//查询所有用户
	@RequestMapping("queryAll")
	public void queryAll() {

	}
	//删除用户
	//更新用户信息

	//登录验证
	@RequestMapping("/login")
	public String login(String id, String pwd, Model model) {
		ActIdUser actIdUser = actIdUserServiceImpl.findById(id);

		if (actIdUser != null) {
			String teststr = actIdUser.getLast() + pwd;//这里的是从数据库获取的随机值+密码的字符串
			String testhashcode_pass = getSHA256StrUtils.getSHA256Str(teststr);//生成一个测试哈希值
			if (actIdUser.getPwd().equals(testhashcode_pass)) {
				// 指定逻辑视图名
				//System.out.println("验证成功");
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
