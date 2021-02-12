package com.jason.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jason.demo.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {
	UserEntity findByOid(Long oid);
	
//	List<UserEntity> findAll();
	

}
