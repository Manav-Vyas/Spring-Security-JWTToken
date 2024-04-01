package com.springsecurity.Service;

import com.springsecurity.Entity.User;

public interface UserService {

	User createUser(User user);
	User getUser(Long id);
}
