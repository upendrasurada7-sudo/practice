package com.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	User findByName(String name);
	
	List<User> findByNameOrId(String Name, int id);
	
	List<User> findAll();
}
