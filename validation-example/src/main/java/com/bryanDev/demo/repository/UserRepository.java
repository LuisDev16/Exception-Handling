package com.bryanDev.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bryanDev.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	User findByUserId(int id);

}
