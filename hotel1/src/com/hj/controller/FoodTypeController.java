package com.hj.controller;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hj.entity.FoodType;
import com.hj.mapper.FoodTypeDaoMapper;

@Controller
public class FoodTypeController {
	@Resource
	private FoodTypeDaoMapper foodTypeDaoMapper;
	@RequestMapping(value="/rlist")
	public String rlist(ModelMap model){
		List rlist=foodTypeDaoMapper.getAllType();
		model.put("rlist", rlist);
		return "sys/cuisineList.jsp";
	}
	@RequestMapping(value="/tadd")
	public String tadd(FoodType pt,ModelMap model){
		if(foodTypeDaoMapper.addType(pt)>0){
			//重定向
			return "redirect:rlist.do";
		}else{
			return "error.jsp";
		}
	}
	@RequestMapping(value="tlist")
	public String tlist(ModelMap model){
		List tlist=foodTypeDaoMapper.getAllType();
		model.put("tlist", tlist);
		return "cuisineList.jsp";
	}
	@RequestMapping(value="/del")
	public String del(int id){
		if(foodTypeDaoMapper.deleteFood(id)>0)
			return "redirect:rlist.do";
		return "error.jsp";
	}
	@RequestMapping(value="/flist")
	public String flist(ModelMap model){
		List flist=foodTypeDaoMapper.getAllType();
		model.put("flist", flist);
		return "sys/updateCuisine.jsp";
	}
	@RequestMapping(value="/toUpdate")
	public String toUpdate(int id,ModelMap model){
		FoodType qb=foodTypeDaoMapper.getFoodType(id);
		model.put("f", qb);
		return "sys/updateCuisine.jsp";
	}
	@RequestMapping(value="/doEdit")
	public String doEdit(FoodType qb,ModelMap model){
		if(foodTypeDaoMapper.editTypeName(qb)>0){
			model.put("msg", "更新成功！");
			return "redirect:rlist.do";
		}else{
			model.put("msg", "失败！");
			return "/sys/error.jsp";
		}
	}
	@RequestMapping(value="/doSearch")
	public String doSearch(FoodType wt,ModelMap model){
		if(foodTypeDaoMapper.doSearchType(wt).size()>0){
			
		List doSearch=foodTypeDaoMapper.doSearchType(wt);
		model.put("rlist", doSearch);
		    return "sys/cuisineList.jsp";
		}else{
			return "error.jsp";
		}
	}
	@RequestMapping(value="/toAddFood")
	public String toAddFood(ModelMap model){
		System.out.println("1111111111111111111111111133333333311111111111");
		List mlist=foodTypeDaoMapper.getAllType();
		model.put("mlist", mlist);
		return "sys/saveFood.jsp";
	}
//	@RequestMapping(value="/login")
//	public String login(UserInfo user,HttpSession session,ModelMap model){
//		UserInfo curUser=userService.login(user);
//		if(curUser!=null){
//			session.setAttribute("currentUser", curUser);
//			return "redirect:/admin/main.jsp";
//		}else{
//			model.put("msg", "用户名或密码错误！");
//			return "/admin/login.jsp";
//		}
//	}
}
