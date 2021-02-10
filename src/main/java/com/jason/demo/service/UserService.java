package com.jason.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jason.demo.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
}
