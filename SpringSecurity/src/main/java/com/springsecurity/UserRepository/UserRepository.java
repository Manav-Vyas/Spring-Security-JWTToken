package com.springsecurity.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
