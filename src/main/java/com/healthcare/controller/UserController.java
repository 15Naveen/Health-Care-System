package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.healthcare.entity.User;
import com.healthcare.service.UserService;

@RestController
@RequestMapping("/healthcaresystem")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping(value="/login",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loginpage(@RequestParam String userName, @RequestParam String userPassword){
		return new ResponseEntity(userService.userlogin(userName, userPassword),HttpStatus.OK);
	}
	
	@PostMapping(value="/register",consumes="application/json")
	public ResponseEntity<String> registerpage(@RequestBody User user){
		return new ResponseEntity(userService.userRegister(user),HttpStatus.OK);
	}
}
