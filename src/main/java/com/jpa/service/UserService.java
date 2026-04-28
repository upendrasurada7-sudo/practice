package com.jpa.service;

import com.jpa.dao.UserRepo;
import com.jpa.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepo userepo;
	
	public void save(User user) {
		
		userepo.save(user);
		
	}
	
	public void find() {
		
		List<User> all = userepo.findAll();	
		
		System.out.println(all);
	}
	
	public void findByName() {
		User byUserName = userepo.findByName("Uppi");
		
		System.out.println(byUserName);
	}
	public List<User> findByNameID(String name, int id) {
		
		return (List<User>) userepo.findByNameOrId(name,id);
	}
	
	public Page<User> findByPage(int pageNumber, int size) {
		PageRequest pageReq = PageRequest.of(pageNumber, size);
		 Page<User> all = userepo.findAll(pageReq);
		 return all;
	}
	

}
