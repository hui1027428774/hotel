package com.hj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hj.entity.UserInfo;
import com.hj.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Resource
	private UserService userService;
	@RequestMapping(value="/login")
	public String login(UserInfo user,HttpSession session,ModelMap model){
		UserInfo curUser=userService.login(user);
		if(curUser!=null){
			session.setAttribute("currentUser", curUser);
			return "redirect:/sys/index.jsp";
		}else{
			model.put("msg", "用户名或密码错误！");
			return "/log.jsp";
		}
	}
	}
