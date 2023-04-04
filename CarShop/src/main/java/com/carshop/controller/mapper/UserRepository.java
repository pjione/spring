package com.carshop.controller.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.carshop.domain.User;

@Mapper
public interface UserRepository {
	int join(User user);
	int insertAuth(String username);
	User existUsername(String email);
}
