package com.jason.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jason.demo.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	User findById(String id);
}
