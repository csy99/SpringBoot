package com.example.controller;

import com.example.dao.UserMapper;
import com.example.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of ADD, Delete, Search, and UPDATE operation in the database.
 * 
 * @author CSY
 *
 */
@RestController
@EnableAutoConfiguration
public class TestController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = "/selectUserById", method = { RequestMethod.POST,
			RequestMethod.GET })
	public User selectUserById(String id) {
		User user = userMapper.selectUserById(Integer.parseInt(id));
		return user;
	}

	@RequestMapping(value = "/selectUserByName", method = { RequestMethod.POST,
			RequestMethod.GET })
	public List<User> selectUserByName(String name) {
		return userMapper.selectUserByName(name);
	}

	@RequestMapping(value = "/addUser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void addUser(User user) {
		userMapper.addUser(user);
	}

	@RequestMapping(value = "/deleteUser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void deleteUser(String id) {
		userMapper.deleteUser(Integer.parseInt(id));
	}

	@RequestMapping(value = "/updateUser", method = { RequestMethod.POST,
			RequestMethod.GET })
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	/**
	 * this is used as a test
	 * 
	 * @return
	 */
	@RequestMapping("/test")
	public String test() {
		return "the page works well";
	}

}
