package com.jpa.Controller;

import com.jpa.model.User;
import com.jpa.service.UserService;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
  UserService userservice;
	
	@PostMapping("/save")
	public String saveUSer(@RequestBody User user) {
		Logger logger = LoggerFactory.getLogger(UserController.class);
		logger.info("Into the saveUser method");
		userservice.save(user);
		
		return "User Saved";
		
	}
	
	@GetMapping("/find")
	public void findUser()	
	{
		
		userservice.find();
	}
	@GetMapping("/findByName")
	public void findByName() {
		userservice.findByName();
	}
	
	@GetMapping("/findByNameOrId")
	public List<User> findByNameOrId(@RequestParam(name = "name") String name, @RequestParam(name = "id") int id) {
		return (List<User>) userservice.findByNameID(name, id);
		 
	}
	@GetMapping("findByPage")
	public Page<User> fibdByPage(@RequestParam(name = "page") int page,@RequestParam(name = "size") int size) {
		return userservice.findByPage(page, size);
	}
}
