package com.hj.mapper;

import java.util.List;

import com.hj.entity.FoodType;

public interface FoodTypeDaoMapper {
	public List<FoodType> getAllType();
	public int addType(FoodType pt);
	public String getTypeName(int _id);
	public int deleteFood(int id);
	public int editTypeName(FoodType qb);
	public FoodType getFoodType(int id);
	public List<FoodType> doSearchType(FoodType wt);
	
	
	
}
