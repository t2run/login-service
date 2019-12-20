package com.example.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.exceptions.UserNotFoundException;
import com.example.rest.jwt.JwtToken;
import com.example.rest.model.UserInfo;
import com.example.rest.service.UserService;


@RestController
public class MyRestController {

private UserService userService;

@Autowired
public MyRestController(UserService userService)
{
	this.userService =userService;
}

	/*
	 * @Autowired JwtToken jwtToken ;
	 */
	
	@CrossOrigin(origins="*")
	@GetMapping("/v2/login")
	public ResponseEntity<Object> login2() throws UserNotFoundException
	{
	
		Map <String,String> user= new HashMap<String, String>(); 
		try {
			 
			UserInfo userInfo= userService.findByUserNamePass("arun", "pass");
			user.put("userName", userInfo.getFirstName()+userInfo.getRole());
		} 
			 catch (UserNotFoundException e1) {
				 return new ResponseEntity<Object> (e1.getMessage(),HttpStatus.UNAUTHORIZED);

			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		return new ResponseEntity<Object> (user,HttpStatus.OK);
		
		}
	
	
	
	@CrossOrigin(origins="*")
	@GetMapping("/login")
	public ResponseEntity<Object> login() throws UserNotFoundException
	{
	
		Map <String,String> user= new HashMap<String, String>(); 
		try {
			 
			List<UserInfo> userInfo= userService.findByFirstName("arun");
			user.put("userName", userInfo.toString());
		} 
			 catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return new ResponseEntity<Object> (user,HttpStatus.OK);
		
		}
	


	@CrossOrigin(origins="*")
	@GetMapping("/v3/login/{user}/{password}")
	public ResponseEntity<Object> login3(@PathVariable("user")String use, @PathVariable("password")String pas ) throws UserNotFoundException
	{
	
		System.out.println(use+"my username "+pas+" my pass");
		Map <String,String> user= new HashMap<String, String>(); 
		try {
			 
			UserInfo userInfo= userService.findByUserNamePass("arun", "pass");
			user.put("userName", userInfo.getFirstName()+userInfo.getRole());
		} 
			 catch (UserNotFoundException e1) {
				 return new ResponseEntity<Object> (e1.getMessage(),HttpStatus.UNAUTHORIZED);

			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		return new ResponseEntity<Object> (user,HttpStatus.OK);
		
		}
	
	
	@CrossOrigin(origins="*")
	@PostMapping("/v4/login/")
	public ResponseEntity<Object> login4( @RequestBody UserInfo use ) throws UserNotFoundException
	{
	
		System.out.println(use.getFirstName()+" "+use.getRole());
		Map <String,String> user= new HashMap<String, String>(); 
		try {
			 
			UserInfo userInfo= userService.findByUserNamePass(use.getFirstName(), use.getPassword());
			if(null!=userInfo)
			user.put("userName", userInfo.getFirstName()+userInfo.getRole());
			user.put("userName", getToken(userInfo.getFirstName(), userInfo.getPassword()));
		} 
			 catch (UserNotFoundException e1) {
				 return new ResponseEntity<Object> (e1.getMessage(),HttpStatus.UNAUTHORIZED);

			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		catch (Exception e1) {
			 return new ResponseEntity<Object> (e1.getMessage(),HttpStatus.UNAUTHORIZED);

		// TODO Auto-generated catch block
		//e1.printStackTrace();
	}
		return new ResponseEntity<Object> (user,HttpStatus.OK);
		
		}
	
	
	// Generate JWT token
		public String getToken(String username, String password) throws Exception {
				
			return JwtToken.getToken(username, password);
	}

}
