package com.ljelectrar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ljelectrar.model.User;
import com.ljelectrar.proxy.UserProxy;

@RestController
@RequestMapping("v1/users")
public class GatewayUserController {
	
	@Autowired
	private UserProxy userProxy;
	
	@GetMapping
	public User[] getUsers() {
		return userProxy.getUsers();
	}
}
