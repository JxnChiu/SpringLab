package com.jason.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jason.demo.dao.UserDao;
import com.jason.demo.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	@Qualifier("UserDao")
	private UserDao dao;

	// 新增 & 修改
	@Transactional
	public UserEntity saveAndFlush(UserEntity entity) {
		return dao.saveAndFlush(entity);
	}
	
	// 刪除
	@Transactional
	public void deleteByLongId(Long oid) {
		dao.deleteById(oid);
	}

	// 查詢
	@Transactional
	public UserEntity getByLongId(Long oid) {
		return dao.getOne(oid);
	}
	
	@Transactional
	public List<UserEntity> getAll(){
		return dao.findAll();
	}

}
