package com.bryanDev.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bryanDev.demo.dto.UserRequest;
import com.bryanDev.demo.entity.User;
import com.bryanDev.demo.exception.UserNotFoundException;
import com.bryanDev.demo.repository.UserRepository;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(UserRequest userRequest) {
		User user=User.build(0,userRequest.getName(),userRequest.getEmail(),
				userRequest.getMobile(),userRequest.getGender(),
				userRequest.getAge(),userRequest.getNationality());
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){	
		return userRepository.findAll();
	}
	
	public User getUserById(int id) throws UserNotFoundException{
	    User user =userRepository.findByUserId(id);
	    if(user!=null) {
	        return user;
	    }else {
	    	throw new UserNotFoundException("user not found with id:" +id);
	    }
	
	}
	
	
//	public User getUser(int id) {
//		Optional<User>user=userRepository.findById(id);
//		return user.get();
//	}
	
}
