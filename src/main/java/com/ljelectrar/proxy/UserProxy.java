package com.ljelectrar.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ljelectrar.model.User;

@Component
public class UserProxy {
	
	private final RestTemplate restTemplate;
	private final String url;
	
	//using contructor injection
	public UserProxy(@Value("${user.url}") String url, RestTemplate restTemplate) {
		this.url = url;
		this.restTemplate = restTemplate;
	}

	public User[] getUsers() {
		return restTemplate.getForObject(url + "v1", User[].class);
	}

	public void create(User user) {
		// TODO Auto-generated method stub
		
	}
	
}
