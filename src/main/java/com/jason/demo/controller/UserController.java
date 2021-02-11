package com.jason.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jason.demo.dao.UserDao;
import com.jason.demo.entity.UserEntity;
import com.jason.utils.JsonUtils;

@RestController
@RequestMapping("/SpringLab/User")
public class UserController {
	private final static Logger logger = LogManager.getLogger();

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = "application/JSON")
	public String addUserPage() {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList = userDao.findAll();

		return JsonUtils.toJsonString(userList);
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addUser(@RequestBody @Validated UserEntity userEntity) {
			
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
		if (violations.isEmpty()) {
			userDao.save(userEntity);
			return "成功";
		} else {
			Set<String> errorSet = new HashSet<String>();
			for (ConstraintViolation<UserEntity> violation : violations) {
				logger.error(violation.getMessage());
				errorSet.add(violation.getMessage());
			}
			return JsonUtils.toJsonString(errorSet);
		}
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public void updateUser(@RequestBody UserEntity userEntity) {
		userDao.save(userEntity);
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody UserEntity userEntity) {
		userDao.delete(userEntity);
	}
}
