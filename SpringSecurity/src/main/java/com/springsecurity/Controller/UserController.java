package com.springsecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.Entity.User;
import com.springsecurity.Service.UserService;

@RestController
@RequestMapping("/secure")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("user")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<> (userService.createUser(user),HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ÚSER') or hasRole('ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id){
		return new ResponseEntity<> (userService.getUser(id), HttpStatus.OK);
	}
}
