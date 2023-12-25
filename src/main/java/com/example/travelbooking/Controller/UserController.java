package com.example.MobileStoreSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.MobileStoreSystem.Service.UserService;
import com.example.MobileStoreSystem.entity.User;

@RestController
public class UserController{

	@Autowired
	UserService userService;
	
	@GetMapping("/loginuser")
	public User loginuser(@RequestHeader String userName ,@RequestHeader String password) {
		return userService.loginuser(userName,password); 
	}
	
	@PostMapping("/postuser")
	public User addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	@PutMapping("/updateuser")
	public User update(@RequestHeader String userName ,@RequestBody User user) {
		
		return userService.updateDb(userName,user); 
	}
	@DeleteMapping("/deleteuser")
	public String delete(@RequestHeader String userName) {
		userService.deleteDb(userName);
		return "data deleted";
	}
	


}
