package com.hj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hj.entity.UserInfo;
import com.hj.mapper.UserMapper;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	public UserInfo login(UserInfo user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}
}
