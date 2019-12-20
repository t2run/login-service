package com.example.rest.service;

import java.util.List;


import com.example.rest.exceptions.UserNotFoundException;
import com.example.rest.model.UserInfo;

public interface UserService {
	
	 List<UserInfo> findByFirstName(String id) throws UserNotFoundException;

	 UserInfo findByUserNamePass(String id, String pass) throws UserNotFoundException;

	//UserInfo findByUserNamePass(String id, String pass);
}
