package com.springsecurity.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.Entity.User;
import com.springsecurity.Exception.ResourceNotFoundException;
import com.springsecurity.Service.UserService;
import com.springsecurity.UserRepository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		User saveuser = userRepository.save(user);
		return saveuser;
	}
	
	@Override
	public User getUser(Long id) {
		User getUser = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("resource not found on server"+id));
		return getUser;
	}
	

}
