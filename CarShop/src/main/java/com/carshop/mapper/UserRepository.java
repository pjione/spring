package com.carshop.mapper;

import com.carshop.domain.User;

public interface UserRepository {
	int join(User user);
	int insertAuth(String username);
}
