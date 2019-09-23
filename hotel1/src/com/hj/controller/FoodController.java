package com.hj.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hj.entity.Food;
import com.hj.mapper.FoodDaoMapper;
import com.hj.mapper.FoodTypeDaoMapper;

@Controller
public class FoodController {
	@Resource
	private FoodDaoMapper foodDaoMapper;
	@Resource
	private FoodTypeDaoMapper foodTypeDaoMapper;
	
	@RequestMapping(value="/addFood")
	public String addProduct(Food p){
		if(foodDaoMapper.addProduct(p)>0)
			return "redirect:plist.do";
		return "error.jsp";
	}
	@RequestMapping(value="/plist")
	public String plist(ModelMap model){
		List<Food> plist=foodDaoMapper.getProducts();
		for (Food food : plist) {
			food.setFoodTypeName(foodTypeDaoMapper.getTypeName(food.getFoodType_id()));
		}
		model.put("plist", plist);
		return "/sys/foodList.jsp";
	}
	
	@RequestMapping(value="/dele")
	public String dele(int id){
		if(foodDaoMapper.deleteFood(id)>0)
			return "redirect:plist.do";
		return "error.jsp";
	}
	@RequestMapping(value="/adFood")
	public String adFood(Food p){
		if(foodDaoMapper.adProduct(p)>0)
			return "redirect:plist.jsp";
		return "error.jsp";
	}
}
