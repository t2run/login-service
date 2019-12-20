package com.example.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.exceptions.UserNotFoundException;
import com.example.rest.model.UserInfo;
import com.example.rest.repository.UserAuthRepository;
@Service
public class UserServiceImpl  implements UserService{
	
	private UserAuthRepository userAuth;
	
	@Autowired
	public UserServiceImpl(UserAuthRepository userAuth)
	{
		this.userAuth=userAuth;
	}
	
	@Override
	public List<UserInfo> findByFirstName (String user) throws UserNotFoundException
	{
		return userAuth.findByFirstName("arun");
	}

	public UserInfo findByUserNamePass(String id, String pass) throws UserNotFoundException {
		UserInfo user =	userAuth.findByUserNamePassword(id, pass);
		if(user==null)
		{
			throw new UserNotFoundException("user not found");
		}
		return user;
	}

}
