package com.hj.mapper;

import java.util.List;

import com.hj.entity.Food;


public interface FoodDaoMapper {
	public int addProduct(Food p);
	public List<Food> getProducts();
	public int deleteFood(int id);
	public int adProduct(Food p);
}
