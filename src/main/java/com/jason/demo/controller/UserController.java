package com.jason.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jason.demo.dao.UserDao;
import com.jason.demo.entity.UserEntity;
import com.jason.utils.JsonUtils;

@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = "application/JSON")
	public String addUserPage() {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList = userDao.findAll();

		return JsonUtils.toJsonString(userList);
	}
}
